package com.graphgrid.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphgrid.core.handler.ResponseHandler;
import com.graphgrid.core.model.GraphGridServiceRequest;
import com.graphgrid.core.model.GraphGridServiceResponse;
import com.graphgrid.core.utils.HttpMethod;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        for ( Map.Entry<String,String> e : headers.entrySet() )
        {
            request.addHeader( e.getKey(), e.getValue() );
        }
        // add request header
        request.addHeader( "User-Agent", USER_AGENT );


        HttpResponse response = client.execute( request );

        return (T) parseResponse( null, response, new ObjectMapper(), responseType );
    }


    public <T extends GraphGridServiceResponse> T parseResponse( ResponseHandler handler, HttpResponse httpResponse, ObjectMapper mapper,
            Class<T> responseType ) throws IOException
    {
        final BufferedReader rd = new BufferedReader( new InputStreamReader( httpResponse.getEntity().getContent() ) );
        final StringBuilder result = new StringBuilder();
        String line = "";
        while ( (line = rd.readLine()) != null )
        {
            result.append( line );
        }
        return (T) mapper.readValue( result.toString(), responseType );
    }

}
