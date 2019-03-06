package com.graphgrid.sdk.core.security;

/**
 * should be default method of authorization
 * will aquere token based on client id and client secret provided by {@link SecurityConfig}
 */
public class ClientCredentialsTokenRequest implements RequestAuthMethod
{
    public ClientCredentialsTokenRequest()
    {
    }
}
