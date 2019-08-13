package com.graphgrid.sdk.core.security;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Use when token is provided by the client
 *
 * @author bradnussbaum
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
    public boolean equals( Object o )
    {
        if ( this == o )
        {
            return true;
        }

        if ( !(o instanceof TokenRequest) )
        {
            return false;
        }

        TokenRequest that = (TokenRequest) o;

        return new EqualsBuilder().append( token, that.token ).isEquals();
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder( 17, 37 ).append( token ).toHashCode();
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder( this ).append( "token", token ).toString();
    }
}
