package com.graphgrid.sdk;

import org.junit.Test;

import com.graphgrid.sdk.core.model.GraphGridServiceRequest;
import com.graphgrid.sdk.core.security.GraphGridSecurityClient;
import com.graphgrid.sdk.core.security.NoTokenRequest;
import com.graphgrid.sdk.core.security.RequestTokenBuilder;
import com.graphgrid.sdk.model.FindFileRequest;

import static org.junit.Assert.assertNotNull;

/**
 * @author bradnussbaum
 */
public class RequestTokenBuilderTest extends TestBase
{
    @Test
    public void builderWithToken()
    {
        final FindFileRequest request = new FindFileRequest().withAuthMethod( new NoTokenRequest() );
        request.setGrn( "" );

        final FindFileRequest authenticate = new RequestTokenBuilder( new GraphGridSecurityClient( securityConfig ) ).authenticate( request );
        assertNotNull( authenticate.getGrn() );
    }

    @Test
    public void builderWithToken2()
    {
        final FindFileRequest request = new FindFileRequest();
        request.setGrn( "" );

        final GraphGridServiceRequest authenticate = new RequestTokenBuilder( new GraphGridSecurityClient( securityConfig ) ).authenticate( request );
        assertNotNull( authenticate.getHeaders() );
    }
}
