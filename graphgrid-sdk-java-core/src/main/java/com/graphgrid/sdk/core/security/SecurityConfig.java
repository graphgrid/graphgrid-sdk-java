package com.graphgrid.sdk.core.security;

/**
 * Holds credentials needed to authenticate and acquire token
 */
public class SecurityConfig
{

    private String clientId;

    private String clientSecret;

    private String baseSecurityEndpoint;

    private String oauthClientId;

    private String oauthClientSecret;

    private String oauthSecurityEndpoint;

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

    public String getBaseSecurityEndpoint()
    {
        return baseSecurityEndpoint;
    }

    public void setBaseSecurityEndpoint( String baseSecurityEndpoint )
    {
        this.baseSecurityEndpoint = baseSecurityEndpoint;
    }

    public String getOauthClientId()
    {
        return oauthClientId;
    }

    public void setOauthClientId( String oauthClientId )
    {
        this.oauthClientId = oauthClientId;
    }

    public String getOauthClientSecret()
    {
        return oauthClientSecret;
    }

    public void setOauthClientSecret( String oauthClientSecret )
    {
        this.oauthClientSecret = oauthClientSecret;
    }

    public String getOauthSecurityEndpoint()
    {
        return oauthSecurityEndpoint;
    }

    public void setOauthSecurityEndpoint( String oauthSecurityEndpoint )
    {
        this.oauthSecurityEndpoint = oauthSecurityEndpoint;
    }
}
