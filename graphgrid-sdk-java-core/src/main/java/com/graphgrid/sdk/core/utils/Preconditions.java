package com.graphgrid.sdk.core.utils;

import com.graphgrid.sdk.core.exception.GraphGridSdkInvalidArgumentException;
import org.apache.commons.lang3.StringUtils;

/**
 * Helper methods for Input validation
 */
public class Preconditions
{
    public final static String NULL_ERROR = "cannot be null";
    public final static String EMPTY_ERROR = NULL_ERROR + " or empty";
    public final static String UNKNOWN_ARG = "na.";
    public final static String VAR = "input variable";

    public static <T> T checkNotNull( T obj, String variableName, String errorMessage )
    {
        if ( obj == null )
        {
            throw new GraphGridSdkInvalidArgumentException( buildErrorMessage( variableName, errorMessage ) );
        }
        return obj;
    }

    public static <T> T checkNotNull( T obj, String variableName )
    {
        return checkNotNull( obj, variableName, NULL_ERROR );
    }

    public static <T> T checkNotNull( T obj )
    {
        return checkNotNull( obj, UNKNOWN_ARG, NULL_ERROR );
    }

    public static String checkNotEmpty( String s, String variableName )
    {
        if ( StringUtils.isBlank( s ) )
        {
            throw new GraphGridSdkInvalidArgumentException( buildErrorMessage( variableName, EMPTY_ERROR ) );
        }
        return s;
    }

    public static String checkNotEmpty( String s )
    {
        return checkNotEmpty( s, UNKNOWN_ARG );
    }


    private static String buildErrorMessage( String variableName )
    {
        return buildErrorMessage( variableName, NULL_ERROR );
    }

    private static String buildErrorMessage( String variableName, String errorMessage )
    {
        return VAR + " " + variableName + " "+ errorMessage;
    }
}
