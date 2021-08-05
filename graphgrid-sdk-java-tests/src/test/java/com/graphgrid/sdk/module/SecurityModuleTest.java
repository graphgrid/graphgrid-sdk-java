package com.graphgrid.sdk.module;

import org.junit.Test;

import com.graphgrid.sdk.SdkTestBase;
import com.graphgrid.sdk.core.GraphGridHttpClient;
import com.graphgrid.sdk.core.model.GetTokenResponse;
import com.graphgrid.sdk.core.model.GetTokenResponseSystem;
import com.graphgrid.sdk.core.security.GraphGridSecurityClient;
import com.graphgrid.sdk.core.security.SecurityService;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author bradnussbaum
 */
public class SecurityModuleTest extends SdkTestBase
{

    @Test
    public void test()
    {
        GraphGridHttpClient client = new GraphGridHttpClient();
        thrown.expect( NullPointerException.class );
        //noinspection ConstantConditions
        client.invoke( null, null, null );
    }

    @Test
    public void getToken()
    {
        final SecurityService securityService = new GraphGridSecurityClient( securityConfig );
        final GetTokenResponse tokenResponse = securityService.getToken( username, password );

        assertNotNull( tokenResponse );
        assertNotNull( tokenResponse.getAccessToken() );
    }

    @Test
    public void getTokenByCredentials()
    {
        final SecurityService securityService = new GraphGridSecurityClient( securityConfig );
        final GetTokenResponse tokenResponse = securityService.getTokenForSecurityCredentials();

        assertNotNull( tokenResponse );
        assertNotNull( tokenResponse.getAccessToken() );
    }

    @Test
    public void getTokenByCredentialsWrongCredentials()
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

    @Test
    public void tokenIsActive()
    {
        final GetTokenResponse getTokenResponse = new GetTokenResponse();
        getTokenResponse.setAccessToken( "1234-123-123-123" );
        getTokenResponse.setCreatedAt( "2019-03-27T19:10:12+00:00" );
        getTokenResponse.setExpiresIn( "36000" ); // current default is 10h
        final GetTokenResponseSystem getTokenResponseSystem = new GetTokenResponseSystem( getTokenResponse );
        assertFalse( getTokenResponseSystem.isExpired() );
    }

    @Test
    public void tokenIsActive2()
    {
        final GetTokenResponse getTokenResponse = new GetTokenResponse();
        getTokenResponse.setAccessToken( "1234-123-123-123" );
        getTokenResponse.setCreatedAt( "2019-03-27T19:10:12+00:00" );
        getTokenResponse.setExpiresIn( "36000" ); // current default is 10h
        final GetTokenResponseSystem getTokenResponseSystem = new GetTokenResponseSystem( getTokenResponse );
        // simulate less than 10h difference
        getTokenResponseSystem.setCreatedAtSystemTime( System.currentTimeMillis() - 59 * 60 * 10 * 1000 );
        assertFalse( getTokenResponseSystem.isExpired() );
    }

    @Test
    public void tokenIsExpired()
    {
        final GetTokenResponse getTokenResponse = new GetTokenResponse();
        getTokenResponse.setAccessToken( "1234-123-123-123" );
        getTokenResponse.setCreatedAt( "2019-03-27T19:10:12+00:00" );
        getTokenResponse.setExpiresIn( "36000" ); // current default is 10h
        final GetTokenResponseSystem getTokenResponseSystem = new GetTokenResponseSystem( getTokenResponse );
        // simulate 10h difference
        getTokenResponseSystem.setCreatedAtSystemTime( System.currentTimeMillis() - 60 * 60 * 10 * 1000 );
        assertTrue( getTokenResponseSystem.isExpired() );
    }

    @Test
    public void tokenIsExpired2()
    {
        final GetTokenResponse getTokenResponse = new GetTokenResponse();
        getTokenResponse.setAccessToken( "1234-123-123-123" );
        getTokenResponse.setCreatedAt( "2019-03-27T19:10:12+00:00" );
        getTokenResponse.setExpiresIn( "36000" ); // current default is 10h
        final GetTokenResponseSystem getTokenResponseSystem = new GetTokenResponseSystem( getTokenResponse );
        // simulate more than 10h difference
        getTokenResponseSystem.setCreatedAtSystemTime( System.currentTimeMillis() - 3 * 60 * 60 * 10 * 1000 );
        assertTrue( getTokenResponseSystem.isExpired() );
    }
}
