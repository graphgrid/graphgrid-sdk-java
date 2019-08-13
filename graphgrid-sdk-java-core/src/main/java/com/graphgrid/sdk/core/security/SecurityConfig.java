package com.graphgrid.sdk.core.security;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Holds credentials needed to authenticate and acquire token
 *
 * @author bradnussbaum
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

    @Override
    public boolean equals( Object o )
    {
        if ( this == o )
        {
            return true;
        }

        if ( !(o instanceof SecurityConfig) )
        {
            return false;
        }

        SecurityConfig that = (SecurityConfig) o;

        return new EqualsBuilder().append( clientId, that.clientId ).append( clientSecret, that.clientSecret ).append( baseSecurityUrl,
                that.baseSecurityUrl ).isEquals();
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder( 17, 37 ).append( clientId ).append( clientSecret ).append( baseSecurityUrl ).toHashCode();
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder( this ).append( "clientId", clientId ).append( "clientSecret", clientSecret ).append( "baseSecurityUrl",
                baseSecurityUrl ).toString();
    }
}
