package com.graphgrid.sdk;

import org.junit.Assert;
import org.junit.Test;

import com.graphgrid.sdk.core.security.ClientCredentialsTokenRequest;
import com.graphgrid.sdk.model.FuzeServiceStatusRequest;
import com.graphgrid.sdk.model.FuzeServiceStatusResponse;

/**
 * @author bradnussbaum
 */
public class FuzeServiceTest extends TestBase
{

    @Test
    public void testStatus()
    {
        final GraphGridFuzeClient client = new GraphGridFuzeClient( "https://dev-api.graphgrid.com/1.0/fuze", securityConfig );
        final FuzeServiceStatusResponse status = client.status( new FuzeServiceStatusRequest().withAuthMethod( new ClientCredentialsTokenRequest() ) );

        Assert.assertNotNull( status );
    }
}
