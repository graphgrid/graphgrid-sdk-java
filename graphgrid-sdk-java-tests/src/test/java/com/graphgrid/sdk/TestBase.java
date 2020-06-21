package com.graphgrid.sdk;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Properties;

import com.graphgrid.sdk.core.security.SecurityConfig;

/**
 * @author bradnussbaum
 */
@ActiveProfiles( "test" )
@RunWith( SpringRunner.class )
@SpringBootTest( classes = App.class, properties = "server.port:0" )
@Rollback( false )
public abstract class TestBase
{

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
        java.io.InputStream is = this.getClass().getClassLoader().getResourceAsStream( "test.properties" );
        java.util.Properties p = new Properties();
        try
        {
            p.load( is );
        }
        catch ( final IOException e )
        {
            e.printStackTrace();
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
