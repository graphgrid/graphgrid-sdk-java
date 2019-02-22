package com.graphgrid.core.handler;

import org.apache.http.HttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DefaultResponseHandler implements ResponseHandler
{
    public String handle( HttpResponse httpResponse ) throws IOException
    {
        final BufferedReader rd = new BufferedReader( new InputStreamReader( httpResponse.getEntity().getContent() ) );
        final StringBuilder result = new StringBuilder();
        String line = "";
        while ( (line = rd.readLine()) != null )
        {
            result.append( line );
        }
        return result.toString();
    }
}
