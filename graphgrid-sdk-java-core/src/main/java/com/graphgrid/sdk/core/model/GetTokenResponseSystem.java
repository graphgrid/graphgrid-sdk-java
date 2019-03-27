package com.graphgrid.sdk.core.model;

import static com.graphgrid.sdk.core.utils.Preconditions.checkNotNull;

/**
 * tracks expiration of token uses System.currentTimeMillis() to avoid constant parsing of times and time zone difference
 */
public class GetTokenResponseSystem
{

    /**
     * uses buffer to acquire new token to avoid making request right when token expires
     */
    private final static long BUFFER_BEFORE_TIMEOUT_SEC = 5L;
    /**
     * system time to avoid time zone issues
     */
    private long createdAtSystemTime;

    private GetTokenResponse getTokenResponse;

    public GetTokenResponseSystem()
    {
        createdAtSystemTime = System.currentTimeMillis();
    }

    public GetTokenResponseSystem( final GetTokenResponse getTokenResponse )
    {
        createdAtSystemTime = System.currentTimeMillis();
        this.getTokenResponse = checkNotNull( getTokenResponse, "getTokenResponse" );
    }

    public long getCreatedAtSystemTime()
    {
        return createdAtSystemTime;
    }

    public void setCreatedAtSystemTime( long createdAtSystemTime )
    {
        this.createdAtSystemTime = createdAtSystemTime;
    }

    public GetTokenResponse getGetTokenResponse()
    {
        return getTokenResponse;
    }

    public void setGetTokenResponse( GetTokenResponse getTokenResponse )
    {
        this.getTokenResponse = getTokenResponse;
    }

    /**
     * @return if token is expired based on the getTokenResponse.getExpiresIn()
     */
    public boolean isExpired()
    {
        return !((createdAtSystemTime +
                // getTokenResponse.getExpiresIn() in sec
                (Long.valueOf( getTokenResponse.getExpiresIn() ) * 1000)) - System.currentTimeMillis() > BUFFER_BEFORE_TIMEOUT_SEC);
    }
}
