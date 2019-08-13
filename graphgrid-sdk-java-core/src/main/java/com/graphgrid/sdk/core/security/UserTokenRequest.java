package com.graphgrid.sdk.core.security;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Will acquire token based on user name and password should only be used for testing purpose
 *
 * @author bradnussbaum
 */
public class UserTokenRequest implements RequestAuthMethod
{

    private String userName;
    private String password;

    public UserTokenRequest( String userName, String password )
    {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName()
    {
        return userName;
    }

    public String getPassword()
    {
        return password;
    }

    @Override
    public boolean equals( Object o )
    {
        if ( this == o )
        {
            return true;
        }

        if ( !(o instanceof UserTokenRequest) )
        {
            return false;
        }

        UserTokenRequest that = (UserTokenRequest) o;

        return new EqualsBuilder().append( userName, that.userName ).append( password, that.password ).isEquals();
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder( 17, 37 ).append( userName ).append( password ).toHashCode();
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder( this ).append( "userName", userName ).append( "password", password ).toString();
    }
}
