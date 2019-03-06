package com.graphgrid.sdk.core.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphgrid.sdk.core.model.GraphGridServiceRequest;
import com.graphgrid.sdk.core.utils.HttpMethod;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.Map;

import static org.apache.http.protocol.HTTP.USER_AGENT;

public class JsonRequestHandler implements RequestHandler
{

    private ObjectMapper objectMapper;

    public JsonRequestHandler()
    {
        this.objectMapper = new ObjectMapper();
    }

    public JsonRequestHandler( ObjectMapper objectMapper )
    {
        this.objectMapper = objectMapper;
    }

    @Override
    public HttpResponse executeRequest( GraphGridServiceRequest request, HttpMethod httpMethod ) throws IOException
    {
        return executeRequest( request, httpMethod, this.objectMapper, HttpClientBuilder.create().build() );
    }

    @Override
    public HttpResponse executeRequest( GraphGridServiceRequest request, HttpMethod httpMethod, HttpClient client ) throws IOException
    {
        return executeRequest( request, httpMethod, this.objectMapper, client );
    }

    @Override
    public HttpResponse executeRequest( GraphGridServiceRequest ggRequest, HttpMethod httpMethod, ObjectMapper objectMapper, HttpClient client )
            throws IOException
    {
        final String url = ggRequest.getEndpoint().toString();

        HttpUriRequest request = null;
        if ( httpMethod == HttpMethod.GET )
        {
            request = new HttpGet( url );
        }
        else if ( httpMethod == HttpMethod.POST )
        {
            request = new HttpPost( url );
            ((HttpPost) request).setEntity( new StringEntity( parseRequestToJsonString( ggRequest.getBody(), objectMapper ) ) );
        }
        else if ( httpMethod == HttpMethod.PUT )
        {
            request = new HttpPut( url );
            ((HttpPut) request).setEntity( new StringEntity( parseRequestToJsonString( ggRequest, objectMapper ) ) );
        }
        else if ( httpMethod == HttpMethod.DELETE )
        {
            request = new HttpDelete( url );
        }
        else if ( httpMethod == HttpMethod.PATCH )
        {
            request = new HttpPatch( url );
        }

        request = addHeaders( ggRequest.getHeaders(), request );

        return client.execute( request );
    }

    private String parseRequestToJsonString( Object obj, ObjectMapper objectMapper ) throws IOException
    {
        return objectMapper.writer().writeValueAsString( obj );
    }

    private HttpUriRequest addHeaders( final Map<String,String> headers, HttpUriRequest request )
    {
        if ( headers != null )
        {
            for ( Map.Entry<String,String> e : headers.entrySet() )
            {
                request.addHeader( e.getKey(), e.getValue() );
            }
        }
        // add request header
        request.addHeader( "User-Agent", USER_AGENT );
        request.addHeader( "Content-type", "application/json" );
        return request;
    }
}
