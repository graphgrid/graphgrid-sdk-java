package com.graphgrid.sdk.core.exception;

public class GraphGridSdkInvalidArgumentException extends GraphGridSdkException
{
    public GraphGridSdkInvalidArgumentException( String message )
    {
        super( message );
    }

    public GraphGridSdkInvalidArgumentException()
    {
        super( "Invalid argument has been used" );
    }

    public GraphGridSdkInvalidArgumentException( String message, Throwable cause )
    {
        super( message, cause );
    }
}
