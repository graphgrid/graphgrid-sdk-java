package com.graphgrid.sdk;

import com.graphgrid.sdk.core.model.GraphGridServiceRequest;
import com.graphgrid.sdk.core.security.GraphGridSecurityClient;
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
        FindFileRequest request = new FindFileRequest( "" ).withAuthMethod( new NoTokenRequest() );
        final FindFileRequest authenticate =
                (FindFileRequest) new RequestTokenBuilder( new GraphGridSecurityClient( securityConfig ) ).authenticate( request );
        assertNotNull( authenticate.getGrn() );
    }

    @Test
    public void builderWithToken2()
    {
        FindFileRequest request = new FindFileRequest( "" );
        final GraphGridServiceRequest authenticate =
                (FindFileRequest) new RequestTokenBuilder( new GraphGridSecurityClient( securityConfig ) ).authenticate( request );
        assertNotNull( authenticate.getHeaders() );
    }

}
