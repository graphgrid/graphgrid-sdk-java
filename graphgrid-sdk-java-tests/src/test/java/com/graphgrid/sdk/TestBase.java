package com.graphgrid.sdk;

import com.graphgrid.sdk.core.security.SecurityConfig;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles( "test" )
@RunWith( SpringRunner.class )
@SpringBootTest( classes = App.class, properties = "server.port:0" )
@Rollback( false )
public abstract class TestBase
{

    // only used to test getting a token for a user
    @Value( "${spring.oauth.username}" )
    protected String username;
    @Value( "${spring.oauth.password}" )
    protected String password;

    // needed to configure security context
    @Value( "${spring.oauth.tokenUrl}" )
    private String springOauthTokenUrl;
    @Value( "${spring.oauth.baseUrl}" )
    private String securityEndpoint;
    @Value( "${spring.oauth.checkTokenUrl}" )
    private String springOAuthCheckTokenUrl;
    @Value( "${spring.oauth.token.client.id}" )
    private String oAuthClientId;
    @Value( "${spring.oauth.token.client.secret}" )
    private String oAuthClientSecret;
    @Value( "${spring.oauth.client.id}" )
    private String clientId;
    @Value( "${spring.oauth.client.secret}" )
    private String clientSecret;

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    protected SecurityConfig securityConfig;

    @Before
    public void setUp() throws Exception
    {
        // todo replace with valid values for testing
        securityConfig = new SecurityConfig();
        securityConfig.setClientId( clientId );
        securityConfig.setClientSecret( clientSecret );
        securityConfig.setOauthClientId( oAuthClientId );
        securityConfig.setOauthClientSecret( oAuthClientSecret );
        securityConfig.setOauthSecurityEndpoint( springOauthTokenUrl );
        securityConfig.setBaseSecurityEndpoint( securityEndpoint );
    }
}
