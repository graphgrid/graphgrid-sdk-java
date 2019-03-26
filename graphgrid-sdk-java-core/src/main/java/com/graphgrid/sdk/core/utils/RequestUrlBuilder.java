package com.graphgrid.sdk.core.utils;

import com.graphgrid.sdk.core.exception.GraphGridSdkInvalidArgumentException;
import com.graphgrid.sdk.core.model.GraphGridServiceRequest;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import static com.graphgrid.sdk.core.utils.Preconditions.checkNotEmpty;
import static com.graphgrid.sdk.core.utils.Preconditions.checkNotNull;

/**
 * wrapper around {@link UrlBuilder} for builds urls for {@link GraphGridServiceRequest}
 * controls if a {@link GraphGridServiceRequest#getEndpoint()} should be overwritten if present
 */
public class RequestUrlBuilder
{
    private static final Logger LOGGER = LoggerFactory.getLogger( RequestUrlBuilder.class );


    private GraphGridServiceRequest request;
    /**
     * if request has url already defined reuse it
     * default is true
     */
    private boolean overwriteUrl = true;

    private UrlBuilder urlBuilder;

    public RequestUrlBuilder( String baseUrl, GraphGridServiceRequest request )
    {
        this.urlBuilder = new UrlBuilder( checkNotEmpty( baseUrl ) );
        this.request = checkNotNull( request, "request" );

        // to ensure custom query parameter dont get overwritten
        if ( request.getCustomQueryParameters() != null )
        {
            urlBuilder.withQueryParams( request.getCustomQueryParameters() );
        }
    }

    public RequestUrlBuilder overwriteUrl( boolean overwriteUrl )
    {
        this.overwriteUrl = overwriteUrl;
        return this;
    }

    public RequestUrlBuilder withServiceEndpoint( String serviceUrl )
    {
        urlBuilder.withServiceEndpoint( serviceUrl );
        return this;
    }

    public RequestUrlBuilder withPathVariables( List<String> pathVariables )
    {
        urlBuilder.withPathVariables( pathVariables );
        return this;
    }

    public RequestUrlBuilder addPathVariable( String pathVariables )
    {
        urlBuilder.addPathVariable( pathVariables );
        return this;
    }

    public RequestUrlBuilder withQueryParams( Map<String,List<String>> queryParameters )
    {
        urlBuilder.withQueryParams( queryParameters );
        return this;
    }

    public RequestUrlBuilder addQueryParam( String key, String value )
    {
        return addQueryParam( key, value, true );
    }

    /**
     * @param key
     * @param value
     * @param required false for optional query params
     * @return
     */
    public RequestUrlBuilder addQueryParam( String key, String value, boolean required )
    {
        urlBuilder.addQueryParam( key, value, required );
        return this;
    }

    public RequestUrlBuilder addQueryParam( String key, List<String> value )
    {
        return addQueryParam( key, value, true );
    }


    /**
     * @param key
     * @param value
     * @param required false for optional query params
     * @return
     */
    public RequestUrlBuilder addQueryParam( String key, List<String> value, boolean required )
    {
        urlBuilder.addQueryParam( key, value, required );
        return this;
    }

    public GraphGridServiceRequest buildRequestWithUrl()
    {
        if ( !overwriteUrl )
        {
            return request;
        }
        else
        {
            request.setEndpoint( buildUrl() );
            return request;
        }
    }

    public URL buildUrl()
    {
        try
        {
            if ( !overwriteUrl )
            {
                return checkNotNull( request.getEndpoint(), "request.endpoint" );
            }
            else
            {
                return urlBuilder.buildUrl();
            }
        }
        catch ( MalformedURLException e )
        {
            LOGGER.error( e.getMessage() );
        }
        throw new GraphGridSdkInvalidArgumentException( "Unable to build url for request" + this.toString() );
    }


    @Override
    public String toString()
    {
        return new ToStringBuilder( this ).append( "request", request ).append( "overwriteUrl", overwriteUrl ).toString();
    }
}
