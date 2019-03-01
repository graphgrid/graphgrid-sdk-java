package com.graphgrid.sdk.core.security;

/**
 * Holds credentials needed to authenticate and acquire token
 */
public class SecurityConfig
{

    private String clientId;

    private String clientSecret;

    private String baseSecurityUrl;

    private String oauthTokenClientId;

    private String oauthTokenClientSecret;

    private String oauthTokenUrl;

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

    public String getOauthTokenClientId()
    {
        return oauthTokenClientId;
    }

    public void setOauthTokenClientId( String oauthTokenClientId )
    {
        this.oauthTokenClientId = oauthTokenClientId;
    }

    public String getOauthTokenClientSecret()
    {
        return oauthTokenClientSecret;
    }

    public void setOauthTokenClientSecret( String oauthTokenClientSecret )
    {
        this.oauthTokenClientSecret = oauthTokenClientSecret;
    }

    public String getOauthTokenUrl()
    {
        return oauthTokenUrl;
    }

    public void setOauthTokenUrl( String oauthTokenUrl )
    {
        this.oauthTokenUrl = oauthTokenUrl;
    }
}
