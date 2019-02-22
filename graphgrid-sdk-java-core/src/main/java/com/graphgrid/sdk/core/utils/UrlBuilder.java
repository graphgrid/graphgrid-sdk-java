package com.graphgrid.sdk.core.utils;

import com.graphgrid.sdk.core.exception.GraphGridSdkInvalidArgumentException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.graphgrid.sdk.core.utils.Preconditions.checkNotEmpty;

/**
 * build raw url
 */
public class UrlBuilder
{

    private static final Logger LOGGER = LoggerFactory.getLogger( UrlBuilder.class );

    private String serviceUrl;
    private String baseUrl;
    private List<String> pathVariables;
    private Map<String,List<String>> queryParameters;

    public UrlBuilder( String baseUrl )
    {
        this.baseUrl = baseUrl;
    }

    public UrlBuilder withBaseUrl( String baseUrl )
    {
        this.baseUrl = baseUrl;
        return this;
    }

    public UrlBuilder withServiceEndpoint( String serviceUrl )
    {
        this.serviceUrl = serviceUrl;
        return this;
    }

    public UrlBuilder withPathVariables( List<String> pathVariables )
    {
        this.pathVariables = pathVariables;
        return this;
    }

    public UrlBuilder addPathVariable( String pathVariables )
    {
        this.pathVariables = Optional.ofNullable( this.pathVariables ).orElse( new LinkedList<>() );
        this.pathVariables.add( pathVariables );
        return this;
    }

    public UrlBuilder withQueryParams( Map<String,List<String>> queryParameters )
    {
        this.queryParameters = queryParameters;
        return this;
    }

    public UrlBuilder addQueryParam( String key, String value )
    {
        queryParameters = Optional.ofNullable( queryParameters ).orElse( new HashMap<String,List<String>>() );
        queryParameters.put( key, Collections.singletonList( value ) );
        return this;
    }

    public UrlBuilder addQueryParam( String key, List<String> value )
    {
        queryParameters = Optional.ofNullable( queryParameters ).orElse( new HashMap<String,List<String>>() );
        queryParameters.put( key, value );
        return this;
    }

    public URL buildUrl()
    {
        try
        {
            return new URL( buildUrlString() );
        }
        catch ( MalformedURLException e )
        {
            LOGGER.error( e.getMessage() );
        }
        throw new GraphGridSdkInvalidArgumentException( "Unable to build url for request" + this.toString() );
    }


    private String buildUrlString()
    {
        final StringBuilder url = new StringBuilder( checkNotEmpty( baseUrl, "base url" ) );
        if ( StringUtils.isNotEmpty( serviceUrl ) )
        {
            url.append( "/" + serviceUrl );
        }
        if ( pathVariables != null && !pathVariables.isEmpty() )
        {
            url.append( "/" + String.join( "/", this.pathVariables ) );
        }
        if ( queryParameters != null && !queryParameters.isEmpty() )
        {
            url.append( "?" + convertQueryParamMapToString( queryParameters ) );
        }
        return url.toString();
    }

    private String convertQueryParamMapToString( Map<String,List<String>> queryParameters )
    {
        StringBuilder queryString = new StringBuilder( "" );
        if ( queryParameters == null || queryParameters.isEmpty() )
        {
            return "";
        }
        else
        {
            for ( Map.Entry<String,List<String>> entry : queryParameters.entrySet() )
            {
                if ( entry.getValue().isEmpty() )
                {
                    continue;
                }
                else if ( entry.getValue().size() == 1 )
                {
                    queryString.append( entry.getKey() + "=" + entry.getValue().get( 0 ) );
                }
                else
                {
                    queryString.append( entry.getKey() + "=" + String.join( ",", entry.getValue() ) );
                }
                queryString.append( "&" );
            }
        }
        return StringUtils.removeEnd( queryString.toString(), "&" );
    }


    @Override
    public String toString()
    {
        return new ToStringBuilder( this ).append( "serviceUrl", serviceUrl ).append( "baseUrl", baseUrl ).append( "pathVariables", pathVariables )
                .append( "queryParameters", queryParameters ).toString();
    }
}
