package com.graphgrid.sdk.core.utils;

import com.graphgrid.sdk.core.model.GraphGridServiceRequest;

/**
 * Preferred way of using {@link com.graphgrid.sdk.core.utils.UrlBuilder} to build request endpoints
 */
public class RequestUrlBuilderFactory
{

    private String baseUrl;

    /**
     * @param baseUrl of a Graph Grid service
     */
    public RequestUrlBuilderFactory( String baseUrl )
    {
        this.baseUrl = baseUrl;
    }

    public UrlBuilder create()
    {
        return new UrlBuilder( baseUrl );
    }

    public RequestUrlBuilder create( final GraphGridServiceRequest request )
    {
        return new RequestUrlBuilder( baseUrl, request );
    }

    public String getBaseUrl()
    {
        return baseUrl;
    }

}
