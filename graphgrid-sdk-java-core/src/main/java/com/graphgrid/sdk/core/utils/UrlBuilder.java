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
import static com.graphgrid.sdk.core.utils.Preconditions.checkNotNull;

/**
 * builds raw url
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
        checkNotEmpty( baseUrl, "baseUrl" );
        this.baseUrl = baseUrl;
        return this;
    }

    public UrlBuilder withServiceEndpoint( String serviceUrl )
    {
        checkNotEmpty( serviceUrl, "serviceUrl" );
        this.serviceUrl = serviceUrl;
        return this;
    }

    public UrlBuilder withPathVariables( List<String> pathVariables )
    {
        return withPathVariables( pathVariables, true );
    }

    /**
     * @param pathVariables
     * @param validated throws exception if invalid input is in list
     * @return
     */
    public UrlBuilder withPathVariables( List<String> pathVariables, boolean validated )
    {
        if ( validated )
        {
            checkNotNull( pathVariables, "pathVariables" );
            pathVariables.forEach( p -> checkNotEmpty( p, "pathVariable for building url" ) );
        }
        this.pathVariables = pathVariables;
        return this;
    }

    public UrlBuilder addPathVariable( String pathVariable )
    {
        return addPathVariable( pathVariable, true );
    }

    /**
     * use when path variable is optional
     *
     * @param pathVariable
     * @param required
     * @return
     */
    public UrlBuilder addPathVariable( String pathVariable, boolean required )
    {
        if ( !required && StringUtils.isBlank( pathVariable ) )
        {
            return this;
        }
        checkNotEmpty( pathVariable, "pathVariable" );
        this.pathVariables = Optional.ofNullable( this.pathVariables ).orElse( new LinkedList<>() );
        this.pathVariables.add( pathVariable );
        return this;
    }

    public UrlBuilder withQueryParams( Map<String,List<String>> queryParameters )
    {
        checkNotNull( queryParameters, "queryParameters" );
        this.queryParameters = queryParameters;
        return this;
    }

    public UrlBuilder addQueryParam( String key, String value )
    {
        return addQueryParam( key, value, true );
    }

    public UrlBuilder addQueryParam( String key, String value, boolean required )
    {

        if ( !required )
        {
            if ( StringUtils.isEmpty( value ) )
            {
                return this;
            }
        }
        checkNotEmpty( key, "key for building url" );
        checkNotNull( value, "value for building url" );
        queryParameters = Optional.ofNullable( queryParameters ).orElse( new HashMap<String,List<String>>() );
        queryParameters.put( key, Collections.singletonList( value ) );
        return this;
    }


    public UrlBuilder addQueryParam( String key, List<String> value )
    {
        return addQueryParam( key, value, true );
    }

    public UrlBuilder addQueryParam( String key, List<String> value, boolean required )
    {
        if ( !required )
        {
            if ( value == null || value.isEmpty() )
            {
                return this;
            }
        }
        checkNotEmpty( key, "key" );
        checkNotNull( value, "value for building url" );
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
