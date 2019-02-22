package com.graphgrid.sdk.core.exception;

public class GraphGridSdkException extends RuntimeException
{
    private int httpStatusCode;

    public GraphGridSdkException( String message )
    {
        super( message );
    }

    public GraphGridSdkException()
    {
        super( "graph grid service error" );
    }

    public GraphGridSdkException( String message, Throwable cause )
    {
        super( message, cause );
    }

    public GraphGridSdkException withStatusCode( int httpStatusCode )
    {
        this.httpStatusCode = httpStatusCode;
        return this;
    }

    public int getHttpStatusCode()
    {
        return httpStatusCode;
    }

    public void setHttpStatusCode( int httpStatusCode )
    {
        this.httpStatusCode = httpStatusCode;
    }
}
