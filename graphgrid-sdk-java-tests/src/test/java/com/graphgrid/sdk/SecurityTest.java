package com.graphgrid.sdk;

import com.graphgrid.sdk.core.GraphGridHttpClient;
import com.graphgrid.sdk.core.model.GetTokenResponse;
import com.graphgrid.sdk.core.security.GraphGridSecurityService;
import com.graphgrid.sdk.core.security.SecurityService;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

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
        final SecurityService securityService = new GraphGridSecurityService( securityConfig );
        final GetTokenResponse tokenResponse = securityService.getToken( username, password );

        assertNotNull( tokenResponse );
        assertNotNull( tokenResponse.getAccessToken() );
    }

    @Test
    public void getTokenByCredentials() throws Exception
    {
        final SecurityService securityService = new GraphGridSecurityService( securityConfig );
        final GetTokenResponse tokenResponse = securityService.getTokenForSecurityCredentials();

        assertNotNull( tokenResponse );
        assertNotNull( tokenResponse.getAccessToken() );
    }

}
