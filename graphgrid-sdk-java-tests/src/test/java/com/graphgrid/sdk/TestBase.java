package com.graphgrid.sdk;

import com.graphgrid.sdk.core.security.SecurityConfig;
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

@ActiveProfiles( "test" )
@RunWith( SpringRunner.class )
@SpringBootTest( classes = App.class, properties = "server.port:0" )
@Rollback( false )
public abstract class TestBase
{

    // only used to test getting a tokenMapper for a user
//    @Value( "${spring.oauth.username}" )
//    protected String username;
//    @Value( "${spring.oauth.password}" )
//    protected String password;

    // needed to configure security context
    //@Value( "${spring.client.id}" )
//    private String clientId;
//    @Value( "${spring.client.secret}" )
//    private String clientSecret;
//    @Value( "${spring.baseSecurityUrl}" )
//    private String baseSecurityUrl;
//    @Value( "${spring.oauth.tokenMapper.url}" )
//    private String springOAuthTokenUrl;
//    @Value( "${spring.oauth.tokenMapper.client.id}" )
//    private String oAuthClientId;
//    @Value( "${spring.oauth.tokenMapper.client.secret}" )
//    private String oAuthClientSecret;


    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    protected SecurityConfig securityConfig;

    protected String username;
    protected String password;

    @Before
    public void setUp() throws Exception
    {
        securityConfig = new SecurityConfig();
        loadSecurityCredentialsFromPom();
    }

    private void loadSecurityCredentialsFromPom()
    {
        java.io.InputStream is = this.getClass().getClassLoader().getResourceAsStream( "test-properties" );
        java.util.Properties p = new Properties();
        try
        {
            p.load( is );
        }
        catch ( final IOException e )
        {
            e.printStackTrace();
        }

        if ( !Boolean.valueOf( p.getProperty( "config.useAsOverwrite" ) ) )
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
