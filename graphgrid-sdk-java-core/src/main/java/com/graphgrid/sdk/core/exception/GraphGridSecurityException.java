package com.graphgrid.sdk.core.exception;

public class GraphGridSecurityException extends GraphGridSdkException
{

    public GraphGridSecurityException()
    {
    }

    public GraphGridSecurityException( String message )
    {
        super( message );
    }

    public GraphGridSecurityException( String message, Throwable cause )
    {
        super( message, cause );
    }
}
