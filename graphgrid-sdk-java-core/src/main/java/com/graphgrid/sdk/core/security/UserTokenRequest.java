package com.graphgrid.sdk.core.security;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * will acquire token based on user name and password
 * should only be used for testing purpose
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
    public String toString()
    {
        return new ToStringBuilder( this ).append( "userName", userName ).append( "password", password ).toString();
    }
}
