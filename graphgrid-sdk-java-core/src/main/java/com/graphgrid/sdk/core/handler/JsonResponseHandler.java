package com.graphgrid.sdk.core.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphgrid.sdk.core.exception.GraphGridSdkException;
import com.graphgrid.sdk.core.model.GraphGridServiceResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JsonResponseHandler<T extends GraphGridServiceResponse> implements ResponseHandler
{

    private static final Logger LOGGER = LoggerFactory.getLogger( JsonResponseHandler.class );

    private String convertToString( final HttpResponse httpResponse )
    {
        final StringBuilder result = new StringBuilder();
        try ( final BufferedReader rd = new BufferedReader( new InputStreamReader( httpResponse.getEntity().getContent() ) ) )
        {
            String line = "";
            while ( (line = rd.readLine()) != null )

            {
                result.append( line );
            }
        }
        catch ( IOException e )
        {
            LOGGER.error( e.getMessage() );
        }
        if ( StringUtils.isEmpty( result ) )
        {
            return "{}";
        }
        return result.toString();
    }

    @Override
    public GraphGridServiceResponse handle( HttpResponse httpResponse, Class responseType ) throws IOException
    {
        return handle( httpResponse, new ObjectMapper(), responseType );
    }

    @Override
    public GraphGridServiceResponse handle( HttpResponse httpResponse, ObjectMapper mapper, Class responseType ) throws IOException
    {
        if ( httpResponse.getStatusLine().getStatusCode() != 200 )
        {
            handleErrorMessage( httpResponse );
        }
        return (T) mapper.readValue( convertToString( httpResponse ), responseType );
    }

    // todo error handler need to be configurable
    private void handleErrorMessage( HttpResponse httpResponse )
    {
        String errorMessage = "";
        try
        {
            errorMessage = convertToString( httpResponse );
        }
        catch ( Exception ex )
        {
            throw new GraphGridSdkException(
                    "{ 'status' :  " + httpResponse.getStatusLine().getStatusCode() + ", 'message' : 'no parseable error message'}" )
                    .withStatusCode( httpResponse.getStatusLine().getStatusCode() );
        }
        if ( StringUtils.isEmpty( errorMessage ) || errorMessage.equals( "{}" ) )
        {
            throw new GraphGridSdkException(
                    "{ 'status' :  " + httpResponse.getStatusLine().getStatusCode() + ", 'message' : 'no parseable error message'}" )
                    .withStatusCode( httpResponse.getStatusLine().getStatusCode() );
        }
        throw new GraphGridSdkException( errorMessage ).withStatusCode( httpResponse.getStatusLine().getStatusCode() );
    }
}
