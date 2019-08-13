package com.graphgrid.sdk.core.security;

import com.graphgrid.sdk.core.model.GetTokenResponse;

/**
 * Used to authenticate and acquire token
 *
 * @author bradnussbaum
 */
public interface SecurityService
{

    GetTokenResponse getToken( String username, String password );

    GetTokenResponse getTokenForSecurityCredentials( String oauthClientId, String oauthClientSecret );

    GetTokenResponse getTokenForSecurityCredentials();
}
