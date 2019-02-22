package com.graphgrid.sdk.core;

import com.graphgrid.sdk.core.security.EmptySecurityConfigs;
import com.graphgrid.sdk.core.security.GraphGridSecurityService;
import com.graphgrid.sdk.core.security.RequestTokenBuilder;
import com.graphgrid.sdk.core.security.SecurityConfig;
import com.graphgrid.sdk.core.security.SecurityService;

import static com.graphgrid.sdk.core.utils.Preconditions.checkNotNull;

/**
 * Adds security services/ context {@link GraphGridServiceBase}
 */
public class GraphGridSecurityAwareServiceBase extends GraphGridServiceBase
{

    private SecurityService securityService;

    private RequestTokenBuilder tokenRequestBuilder;

    public GraphGridSecurityAwareServiceBase( String serviceBaseUrl )
    {
        super( serviceBaseUrl );
        configureSecurityService( new EmptySecurityConfigs() );
    }

    public GraphGridSecurityAwareServiceBase( String serviceBaseUrl, SecurityConfig securityConfig )
    {
        super( serviceBaseUrl, securityConfig );
        configureSecurityService( securityConfig );
    }

    public GraphGridSecurityAwareServiceBase( GraphGridHttpClient client, String serviceBaseUrl, SecurityConfig securityConfig )
    {
        super( client, serviceBaseUrl, securityConfig );
        configureSecurityService( securityConfig );
    }

    private void configureSecurityService( SecurityConfig securityConfig )
    {
        checkNotNull( securityConfig, "securityConfig" );
        securityService = new GraphGridSecurityService( securityConfig );
        tokenRequestBuilder = new RequestTokenBuilder( securityService );
    }

    public SecurityService getSecurityService()
    {
        return securityService;
    }

    public void setSecurityService( SecurityService securityService )
    {
        this.securityService = securityService;
    }

    public RequestTokenBuilder getTokenRequestBuilder()
    {
        return tokenRequestBuilder;
    }

    public void setTokenRequestBuilder( RequestTokenBuilder tokenRequestBuilder )
    {
        this.tokenRequestBuilder = tokenRequestBuilder;
    }
}
