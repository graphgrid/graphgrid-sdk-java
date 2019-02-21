package com.graphgrid.sdk.core.model;


import com.graphgrid.sdk.core.handler.RequestHandler;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

abstract public class GraphGridServiceRequest
{

    private URL endpoint;
    private Object body;
    private Map<String,String> headers;
    private Map<String,List<String>> customQueryParameters;
    private RequestHandler requestHandler;

    @SuppressWarnings( "unchecked" )
    public <T extends GraphGridServiceRequest> T withHeaders( Map<String,String> headers )
    {
        setHeaders( headers );
        T t = (T) this;
        return t;
    }

    public URL getEndpoint() throws MalformedURLException
    {
        return endpoint;
    }

    public void setEndpoint( URL endpoint )
    {
        this.endpoint = endpoint;
    }

    public Object getBody()
    {
        return body;
    }

    public void setBody( Object body )
    {
        this.body = body;
    }

    public Map<String,String> getHeaders()
    {
        return headers;
    }

    public void setHeaders( Map<String,String> headers )
    {
        this.headers = headers;
    }

    public Map<String,List<String>> getCustomQueryParameters()
    {
        return customQueryParameters;
    }

    public void setCustomQueryParameters( Map<String,List<String>> customQueryParameters )
    {
        this.customQueryParameters = customQueryParameters;
    }
}
