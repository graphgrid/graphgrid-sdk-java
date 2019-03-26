package com.graphgrid.sdk;

import com.graphgrid.sdk.core.GraphGridHttpClient;
import com.graphgrid.sdk.core.model.GetTokenResponse;
import com.graphgrid.sdk.core.security.GraphGridSecurityClient;
import com.graphgrid.sdk.core.security.SecurityService;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SecurityTest extends TestBase
{

    @Test
    public void test() throws IOException
    {
        GraphGridHttpClient client = new GraphGridHttpClient();
        thrown.expect( NullPointerException.class );
        client.invoke( null, null, null );
    }

    @Test
    public void getToken() throws Exception
    {
        final SecurityService securityService = new GraphGridSecurityClient( securityConfig );
        final GetTokenResponse tokenResponse = securityService.getToken( username, password );

        assertNotNull( tokenResponse );
        assertNotNull( tokenResponse.getAccessToken() );
    }

    @Test
    public void getTokenByCredentials() throws Exception
    {
        final SecurityService securityService = new GraphGridSecurityClient( securityConfig );
        final GetTokenResponse tokenResponse = securityService.getTokenForSecurityCredentials();

        assertNotNull( tokenResponse );
        assertNotNull( tokenResponse.getAccessToken() );
    }

    @Test
    public void getTokenByCredentialsWrongCredentials() throws Exception
    {
        com.graphgrid.sdk.core.exception.GraphGridSdkException exception = null;
        securityConfig.setClientId( "invalid-id" );
        final SecurityService securityService = new GraphGridSecurityClient( securityConfig );
        try
        {
            securityService.getTokenForSecurityCredentials();
        }
        catch ( com.graphgrid.sdk.core.exception.GraphGridSdkException ex )
        {
            exception = ex;
        }

        assertNotNull( exception );
        assertTrue( exception.getMessage().contains( "Unauthorized" ) );
    }

}
