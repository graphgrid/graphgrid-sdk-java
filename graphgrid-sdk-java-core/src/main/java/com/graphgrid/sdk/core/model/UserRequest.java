package com.graphgrid.sdk.core.model;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Holds information specific to each call executed against the sdk.
 * Can be used for monitoring and logging.
 */
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

    public void setStarted( String started )
    {
        this.started = started;
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder( this ).append( "started", started ).append( "token", token ).append( "requestId", requestId ).toString();
    }
}
