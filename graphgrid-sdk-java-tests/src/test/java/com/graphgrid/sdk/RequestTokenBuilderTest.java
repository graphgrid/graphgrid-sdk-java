package com.graphgrid.sdk;

import com.graphgrid.sdk.core.model.GraphGridServiceRequest;
import com.graphgrid.sdk.core.security.ClientCredentialsTokenRequest;
import com.graphgrid.sdk.core.security.GraphGridSecurityService;
import com.graphgrid.sdk.core.security.NoTokenRequest;
import com.graphgrid.sdk.core.security.RequestTokenBuilder;
import com.graphgrid.sdk.model.FindFileRequest;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class RequestTokenBuilderTest extends TestBase
{
    @Test
    public void builderWithToken()
    {
        FindFileRequest request = new FindFileRequest( new NoTokenRequest(), "" );
        final FindFileRequest authenticate =
                (FindFileRequest) new RequestTokenBuilder( new GraphGridSecurityService( securityConfig ) ).authenticate( request );
        assertNotNull( authenticate.getGrn() );
    }

    @Test
    public void builderWithToken2()
    {
        FindFileRequest request = new FindFileRequest( new ClientCredentialsTokenRequest(), "" );
        final GraphGridServiceRequest authenticate =
                (FindFileRequest) new RequestTokenBuilder( new GraphGridSecurityService( securityConfig ) ).authenticate( request );
        assertNotNull( authenticate.getHeaders() );
    }

}
