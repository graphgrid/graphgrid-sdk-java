package com.graphgrid.sdk.core.utils;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.graphgrid.sdk.core.model.GraphGridServiceRequest;

/**
 * Preferred way of using {@link com.graphgrid.sdk.core.utils.UrlBuilder} to build request endpoints
 *
 * @author bradnussbaum
 */
public class RequestUrlBuilderFactory
{

    private String baseUrl;

    /**
     * @param baseUrl the base service URL
     */
    public RequestUrlBuilderFactory( String baseUrl )
    {
        this.baseUrl = baseUrl;
    }

    public UrlBuilder create()
    {
        return new UrlBuilder( baseUrl );
    }

    public RequestUrlBuilder create( final GraphGridServiceRequest request )
    {
        return new RequestUrlBuilder( baseUrl, request );
    }

    public String getBaseUrl()
    {
        return baseUrl;
    }

    @Override
    public boolean equals( Object o )
    {
        if ( this == o )
        {
            return true;
        }

        if ( !(o instanceof RequestUrlBuilderFactory) )
        {
            return false;
        }

        RequestUrlBuilderFactory that = (RequestUrlBuilderFactory) o;

        return new EqualsBuilder().append( baseUrl, that.baseUrl ).isEquals();
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder( 17, 37 ).append( baseUrl ).toHashCode();
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder( this ).append( "baseUrl", baseUrl ).toString();
    }
}
