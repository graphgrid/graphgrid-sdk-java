package com.graphgrid.sdk;

import com.graphgrid.sdk.core.GraphGridHttpClient;
import com.graphgrid.sdk.core.model.GraphGridServiceRequest;
import com.graphgrid.sdk.core.utils.HttpMethod;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

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
    @Ignore
    public void testToken() throws IOException
    {
        GraphGridHttpClient client = new GraphGridHttpClient();
        client.invoke( new GraphGridServiceRequest()
        {
            @Override
            public URL getEndpoint() throws MalformedURLException
            {
                return new URL( "http://local-api.graphgrid.com/1.0/security/token" );
            }
        }, null, HttpMethod.POST );
    }

    @Test
    @Ignore
    public void testToken2() throws IOException
    {
        // TODO
    }

}
