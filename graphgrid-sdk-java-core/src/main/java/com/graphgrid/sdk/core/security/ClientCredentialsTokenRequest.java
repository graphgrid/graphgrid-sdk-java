package com.graphgrid.sdk.core.security;

/**
 * Should be default method of authorization will acquire token based on client id and client secret provided by {@link SecurityConfig}
 *
 * @author bradnussbaum
 */
public class ClientCredentialsTokenRequest implements RequestAuthMethod
{

    public ClientCredentialsTokenRequest()
    {
    }
}
