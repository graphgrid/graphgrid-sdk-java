package com.graphgrid.sdk.core.security;

/**
 * Holds credentials needed to authenticate and acquire token
 */
public class SecurityConfig
{
    private String clientId;

    private String clientSecret;

    private String baseSecurityUrl;

    public String getClientId()
    {
        return clientId;
    }

    public void setClientId( String clientId )
    {
        this.clientId = clientId;
    }

    public String getClientSecret()
    {
        return clientSecret;
    }

    public void setClientSecret( String clientSecret )
    {
        this.clientSecret = clientSecret;
    }

    public String getBaseSecurityUrl()
    {
        return baseSecurityUrl;
    }

    public void setBaseSecurityUrl( String baseSecurityUrl )
    {
        this.baseSecurityUrl = baseSecurityUrl;
    }

}
