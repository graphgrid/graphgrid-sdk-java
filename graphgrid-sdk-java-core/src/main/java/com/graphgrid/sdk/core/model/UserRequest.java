package com.graphgrid.sdk.core.model;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class UserRequest
{
    private String started;

    private String token;

    private String requestId;

    public UserRequest( String token )
    {
        this.token = token;
        this.requestId = RandomStringUtils.randomAlphanumeric( 20 );
    }


    public String getStarted()
    {
        return started;
    }

    public String getToken()
    {
        return token;
    }

    public String getRequestId()
    {
        return requestId;
    }


    @Override
    public String toString()
    {
        return new ToStringBuilder( this ).append( "started", started ).append( "token", token ).append( "requestId", requestId ).toString();
    }
}
