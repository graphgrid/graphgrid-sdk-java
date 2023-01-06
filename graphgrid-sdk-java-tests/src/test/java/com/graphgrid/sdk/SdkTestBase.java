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

import com.graphgrid.sdk.core.exception.GraphGridSdkInvalidArgumentException;
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

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    protected SecurityConfig securityConfig;

    protected String username;
    protected String password;

    private Properties p = new Properties();

    @Before
    public void setUp()
    {
        securityConfig = new SecurityConfig();
        loadSecurityCredentialsFromPom();
    }

    private void loadSecurityCredentialsFromPom()
    {
        java.io.InputStream is = this.getClass().getClassLoader().getResourceAsStream( "test.properties" );
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

        final String clientId = getPropertyValueAndThrowErrorIfMissing( "client.id" );
        final String clientSecret = getPropertyValueAndThrowErrorIfMissing( "client.secret" );
        final String baseSecurityUrl = getPropertyValueAndThrowErrorIfMissing( "baseSecurityUrl" );
        final String oauthUsername = getPropertyValueAndThrowErrorIfMissing( "oauth.username" );
        final String oauthPassword = getPropertyValueAndThrowErrorIfMissing( "oauth.password" );

        securityConfig.setClientId( clientId );
        securityConfig.setClientSecret( clientSecret );
        securityConfig.setBaseSecurityUrl( baseSecurityUrl );

        username = oauthUsername;
        password = oauthPassword;
    }

    private String getPropertyValueAndThrowErrorIfMissing( String propName ) throws GraphGridSdkInvalidArgumentException
    {
        String propValue = p.getProperty( propName );
        if ( propValue == null || propValue.isEmpty() )
        {
            throw new GraphGridSdkInvalidArgumentException( "Property '" + propName + "' is missing or empty. " +
                    "Graphgrid-java-sdk tests require this property to be non-empty (set directly in the test pom or through the properties in your maven settings.xml)" );
        }
        return propValue;
    }
}
