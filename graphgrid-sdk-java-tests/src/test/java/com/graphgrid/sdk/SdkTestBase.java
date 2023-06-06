package com.graphgrid.sdk;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.graphgrid.sdk.core.security.SecurityConfig;

/**
 * @author bradnussbaum
 */
@ActiveProfiles( "test" )
@RunWith( SpringRunner.class )
@SpringBootTest( classes = SdkTestModule.class, properties = "server.port:0" )
@Rollback( false )
public abstract class SdkTestBase
{

    private static final Logger LOGGER = LoggerFactory.getLogger( SdkTestBase.class );

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    protected SecurityConfig securityConfig;

    protected String username;
    protected String password;

    @Before
    public void setUp()
    {
        securityConfig = new SecurityConfig();
        loadSecurityCredentialsFromPom();
    }

    private void loadSecurityCredentialsFromPom()
    {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream( "test.properties" );
        Properties p = new Properties();
        try
        {
            p.load( is );
        }
        catch ( final IOException e )
        {
            LOGGER.error( e.getMessage(), e );
        }

        if ( !Boolean.parseBoolean( p.getProperty( "config.useAsOverwrite" ) ) )
        {
            return;
        }

        securityConfig.setClientId( p.getProperty( "client.id" ) );
        securityConfig.setClientSecret( p.getProperty( "client.secret" ) );
        securityConfig.setBaseSecurityUrl( p.getProperty( "baseSecurityUrl" ) );

        username = p.getProperty( "oauth.username" );
        password = p.getProperty( "oauth.password" );
    }
}
