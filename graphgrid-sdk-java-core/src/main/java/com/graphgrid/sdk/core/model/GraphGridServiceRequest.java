package com.graphgrid.sdk.core.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.graphgrid.sdk.core.handler.RequestHandler;
import com.graphgrid.sdk.core.handler.ResponseHandler;
import com.graphgrid.sdk.core.security.ClientCredentialsTokenRequest;
import com.graphgrid.sdk.core.security.RequestAuthMethod;
import com.graphgrid.sdk.core.utils.ExecutionContext;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


abstract public class GraphGridServiceRequest
{
    @JsonIgnore
    private URL endpoint;
    @JsonIgnore
    private String serviceUrl;
    @JsonIgnore
    private Object body;
    @JsonIgnore
    private Map<String,String> headers;
    @JsonIgnore
    private Map<String,List<String>> customQueryParameters;
    @JsonIgnore
    private RequestHandler requestHandler;
    @JsonIgnore
    private ResponseHandler responseHandler;
    @JsonIgnore
    private RequestAuthMethod requestAuthMethod;
    @JsonIgnore
    private ExecutionContext context;

    public GraphGridServiceRequest()
    {
        this.requestAuthMethod = new ClientCredentialsTokenRequest();
    }

    public GraphGridServiceRequest( RequestAuthMethod requestAuthMethod )
    {
        this.requestAuthMethod = requestAuthMethod;
    }

    @SuppressWarnings( "unchecked" )
    public <T extends GraphGridServiceRequest> T withHeaders( Map<String,String> headers )
    {
        setHeaders( headers );
        T t = (T) this;
        return t;
    }

    @SuppressWarnings( "unchecked" )
    public <T extends GraphGridServiceRequest> T addHeader( String key, String value )
    {
        final Map<String,String> map = Optional.ofNullable( this.headers ).orElse( new HashMap<>() );
        map.put( key, value );
        setHeaders( map );
        T t = (T) this;
        return t;
    }

    @SuppressWarnings( "unchecked" )
    public <T extends GraphGridServiceRequest> T withAuthMethod( RequestAuthMethod authenticationMethod )
    {
        setRequestAuthMethod( authenticationMethod );
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

    public RequestHandler getRequestHandler()
    {
        return requestHandler;
    }

    public void setRequestHandler( RequestHandler requestHandler )
    {
        this.requestHandler = requestHandler;
    }

    public ResponseHandler getResponseHandler()
    {
        return responseHandler;
    }

    public void setResponseHandler( ResponseHandler responseHandler )
    {
        this.responseHandler = responseHandler;
    }

    public String getServiceUrl()
    {
        return serviceUrl;
    }

    public void setServiceUrl( String serviceUrl )
    {
        this.serviceUrl = serviceUrl;
    }

    public RequestAuthMethod getRequestAuthMethod()
    {
        return requestAuthMethod;
    }

    public void setRequestAuthMethod( RequestAuthMethod requestAuthMethod )
    {
        this.requestAuthMethod = requestAuthMethod;
    }


    @Override
    public String toString()
    {
        return new ToStringBuilder( this ).append( "endpoint", endpoint ).append( "serviceUrl", serviceUrl ).append( "body", body ).append( "headers", headers )
                .append( "customQueryParameters", customQueryParameters ).append( "requestHandler", requestHandler )
                .append( "responseHandler", responseHandler ).append( "requestAuthMethod", requestAuthMethod ).toString();
    }
}
