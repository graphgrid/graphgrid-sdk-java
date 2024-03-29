package com.graphgrid.sdk.support;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.function.Supplier;

import com.graphgrid.sdk.core.SessionFactory;
import com.graphgrid.sdk.core.SpringSecurityContextTokenFactory;
import com.graphgrid.sdk.core.model.GraphGridSecurityRequest;
import com.graphgrid.sdk.core.model.GraphGridServiceRequest;

import static org.junit.Assert.assertTrue;

/**
 * @author bradnussbaum
 */
public class SessionFactoryTest
{

    private Supplier<Object> contextSupplier = MockSecurityContext::new;

    @Before
    public void setUp()
    {
    }

    @Test
    public void getTokenFromMockSupplier()
    {
        final SessionFactory sessionFactory = new SpringSecurityContextTokenFactory( contextSupplier );

        assertTrue( sessionFactory.getTokenFromRequest().contains( "mock-token" ) );
    }

    @Test
    public void getManyTokens()
    {
        final SessionFactory sessionFactory = new SpringSecurityContextTokenFactory( contextSupplier );

        assertTrue( sessionFactory.getTokenFromRequest().contains( "mock-token" ) );
    }

    @Test
    public void addTokenToRequest()
    {
        final SessionFactory sessionFactory = new SpringSecurityContextTokenFactory( contextSupplier );
        final GraphGridServiceRequest request = sessionFactory.addTokenToRequest( new GraphGridSecurityRequest() );

        assertTrue( request.getHeaders().get( SpringSecurityContextTokenFactory.GRAPHGRID_USER_TOKEN ).contains( "mock-token" ) );
    }

    @Test
    public void addTokenToRequestNullSupplier()
    {
        final SessionFactory sessionFactory = new SpringSecurityContextTokenFactory( () -> null );
        final GraphGridServiceRequest request = sessionFactory.addTokenToRequest( new GraphGridSecurityRequest() );

        assertTrue( request.getHeaders().get( SpringSecurityContextTokenFactory.GRAPHGRID_USER_TOKEN ).contains( "null" ) );
    }

    @Test
    public void addTokenToRequestNullEmptyHashMap()
    {
        final SessionFactory sessionFactory = new SpringSecurityContextTokenFactory( HashMap::new );
        final GraphGridServiceRequest request = sessionFactory.addTokenToRequest( new GraphGridSecurityRequest() );

        assertTrue( request.getHeaders().get( SpringSecurityContextTokenFactory.GRAPHGRID_USER_TOKEN ).contains( "null" ) );
    }

    static class MockSecurityContext
    {
        private String tokenValue;
        private String remoteAddress;

        public MockSecurityContext()
        {
            this.tokenValue = "mock-token-" + RandomStringUtils.randomNumeric( 10 );
            this.remoteAddress = "127-0-0-0";
        }

        public String getTokenValue()
        {
            return tokenValue;
        }

        public void setTokenValue( String tokenValue )
        {
            this.tokenValue = tokenValue;
        }

        public String getRemoteAddress()
        {
            return remoteAddress;
        }

        public void setRemoteAddress( String remoteAddress )
        {
            this.remoteAddress = remoteAddress;
        }
    }
}
