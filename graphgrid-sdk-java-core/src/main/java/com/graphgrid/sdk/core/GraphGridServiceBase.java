package com.graphgrid.sdk.core;

import com.graphgrid.sdk.core.security.EmptySecurityConfigs;
import com.graphgrid.sdk.core.security.SecurityConfig;
import com.graphgrid.sdk.core.utils.RequestUrlBuilderFactory;

/**
 * base service for other graph grid client services
 */
public abstract class GraphGridServiceBase
{
    private GraphGridHttpClient client;

    private String serviceBaseUrl;

    private SecurityConfig securityConfig;

    private RequestUrlBuilderFactory endpointBuilder;

    @Deprecated
    public GraphGridServiceBase()
    {
        this.client = new GraphGridHttpClient();
    }

    public GraphGridServiceBase( String serviceBaseUrl )
    {
        this( new GraphGridHttpClient(), serviceBaseUrl, new EmptySecurityConfigs() );
    }

    public GraphGridServiceBase( String serviceBaseUrl, SecurityConfig securityConfig )
    {
        this( new GraphGridHttpClient(), serviceBaseUrl, securityConfig );
    }

    public GraphGridServiceBase( GraphGridHttpClient client, String serviceBaseUrl, SecurityConfig securityConfig )
    {
        this.client = client;
        this.serviceBaseUrl = serviceBaseUrl;
        this.securityConfig = securityConfig;
        this.endpointBuilder = new RequestUrlBuilderFactory( getServiceBaseUrl() );
    }


    public GraphGridHttpClient getClient()
    {
        return client;
    }

    public String getServiceBaseUrl()
    {
        return serviceBaseUrl;
    }

    public SecurityConfig getSecurityConfig()
    {
        return securityConfig;
    }

    public RequestUrlBuilderFactory getEndpointBuilder()
    {
        return endpointBuilder;
    }
}
