package com.graphgrid.sdk.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphgrid.core.handler.DefaultResponseHandler;
import com.graphgrid.core.handler.ResponseHandler;
import com.graphgrid.core.model.GraphGridServiceRequest;
import com.graphgrid.core.model.GraphGridServiceResponse;
import com.graphgrid.core.utils.HttpMethod;
import com.graphgrid.sdk.core.handler.ResponseHandler;
import com.graphgrid.sdk.core.model.GraphGridServiceRequest;
import com.graphgrid.sdk.core.model.GraphGridServiceResponse;
import com.graphgrid.sdk.core.utils.HttpMethod;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.Map;

import static org.apache.http.protocol.HTTP.USER_AGENT;

public class GraphGridHttpClient
{


    public <T extends GraphGridServiceResponse> T invoke( GraphGridServiceRequest ggRequest, Class<T> responseType, HttpMethod httpMethod ) throws IOException
    {
        String url = ggRequest.getEndpoint().toString();
        HttpClient client = HttpClientBuilder.create().build();
        final HttpGet request = new HttpGet( url );


        final Map<String,String> headers = ggRequest.getHeaders();
        if ( headers != null )
        {
            for ( Map.Entry<String,String> e : headers.entrySet() )
            {
                request.addHeader( e.getKey(), e.getValue() );
            }
        }
        // add request header
        request.addHeader( "User-Agent", USER_AGENT );


        HttpResponse response = client.execute( request );

        return (T) parseResponse( response, responseType );
    }


    public <T extends GraphGridServiceResponse> T parseResponse( HttpResponse httpResponse,
            Class<T> responseType ) throws IOException
    {
        return (T) new ObjectMapper().readValue( new DefaultResponseHandler().handle( httpResponse ), responseType );
    }

    public <T extends GraphGridServiceResponse> T parseResponse( HttpResponse httpResponse, ObjectMapper mapper, Class<T> responseType ) throws IOException
    {
        return (T) mapper.readValue( new DefaultResponseHandler().handle( httpResponse ), responseType );
    }

    public <T extends GraphGridServiceResponse> T parseResponse( ResponseHandler handler, HttpResponse httpResponse, ObjectMapper mapper,
            Class<T> responseType ) throws IOException
    {
        return (T) mapper.readValue( handler.handle( httpResponse ), responseType );
    }

}
