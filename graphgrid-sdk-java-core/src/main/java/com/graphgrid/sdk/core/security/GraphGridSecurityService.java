package com.graphgrid.sdk.core.security;

import com.graphgrid.sdk.core.GraphGridHttpClient;
import com.graphgrid.sdk.core.GraphGridServiceBase;
import com.graphgrid.sdk.core.handler.UrlEncodedRequestHandler;
import com.graphgrid.sdk.core.model.GetTokenResponse;
import com.graphgrid.sdk.core.model.GraphGridSecurityRequest;
import com.graphgrid.sdk.core.utils.HttpMethod;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static com.graphgrid.sdk.core.utils.Preconditions.checkNotEmpty;
import static com.graphgrid.sdk.core.utils.Preconditions.checkNotNull;

public class GraphGridSecurityService extends GraphGridServiceBase implements SecurityService
{
    private static final String AUTH_HEADER_KEY = "Authorization";
    private static final String BASIC_HEADER_KEY = "Basic ";
    private static final String GRANT_TYPE_KEY = "grant_type";
    private static final String PASSWORD_KEY = "password";
    private static final String USERNAME_KEY = "username";

    private static final Logger LOGGER = LoggerFactory.getLogger( SecurityService.class );

    private SecurityConfig securityConfig;

    public GraphGridSecurityService( SecurityConfig securityConfig )
    {
        super( securityConfig.getBaseSecurityUrl() );
        this.securityConfig = securityConfig;
    }

    public GraphGridSecurityService( GraphGridHttpClient client, SecurityConfig securityConfig )
    {
        super( client, securityConfig.getBaseSecurityUrl(), securityConfig );
    }

    public GetTokenResponse getToken( String username, String password )
    {
        checkNotNull( username, "username" );
        checkNotNull( password, "password" );

        final List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add( new BasicNameValuePair( PASSWORD_KEY, password ) );
        nvps.add( new BasicNameValuePair( USERNAME_KEY, username ) );
        nvps.add( new BasicNameValuePair( GRANT_TYPE_KEY, "password" ) );

        final GraphGridSecurityRequest ggRequest = new GraphGridSecurityRequest();
        ggRequest.addHeader( AUTH_HEADER_KEY, baseEncodedHeader( securityConfig.getClientId(), securityConfig.getClientSecret() ) );
        ggRequest.setRequestHandler( new UrlEncodedRequestHandler() );
        ggRequest.setBody( nvps );
        ggRequest.setEndpoint( getEndpointBuilder().create().buildUrl() );

        return getClient().invoke( ggRequest, GetTokenResponse.class, HttpMethod.POST );
    }


    public GetTokenResponse getTokenForSecurityCredentials( String oauthClientId, String oauthClientSecret )
    {
        checkNotEmpty( oauthClientId, "oauthClientId" );
        checkNotEmpty( oauthClientSecret, "oauthClientSecret" );

        final List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add( new BasicNameValuePair( GRANT_TYPE_KEY, "client_credentials" ) );

        final GraphGridSecurityRequest ggRequest = new GraphGridSecurityRequest();
        ggRequest.addHeader( AUTH_HEADER_KEY, baseEncodedHeader( oauthClientId, oauthClientSecret ) );
        ggRequest.setRequestHandler( new UrlEncodedRequestHandler() );
        ggRequest.setBody( nvps );
        ggRequest.setEndpoint( getEndpointBuilder().create().buildUrl() );

        return getClient().invoke( ggRequest, GetTokenResponse.class, HttpMethod.POST );
    }

    public GetTokenResponse getTokenForSecurityCredentials()
    {
        return getTokenForSecurityCredentials( securityConfig.getOauthTokenClientId(), securityConfig.getOauthTokenClientSecret() );
    }

    private String baseEncodedHeader( String clientId, String clientKey )
    {
        final String auth = clientId + ":" + clientKey;
        byte[] encodedAuth = Base64.encodeBase64( auth.getBytes( StandardCharsets.ISO_8859_1 ) );
        return BASIC_HEADER_KEY + new String( encodedAuth );
    }

}