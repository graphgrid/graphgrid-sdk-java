package com.graphgrid.sdk.core.security;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * use when token is provided by the client
 */
public class TokenRequest implements RequestAuthMethod
{
    private String token;

    public TokenRequest( String token )
    {
        this.token = token;
    }

    public String getToken()
    {
        return token;
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder( this ).append( "token", token ).toString();
    }
}
