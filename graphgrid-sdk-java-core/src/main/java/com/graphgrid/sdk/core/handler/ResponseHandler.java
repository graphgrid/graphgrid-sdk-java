package com.graphgrid.sdk.core.handler;

import org.apache.http.HttpResponse;

import java.io.IOException;

public interface ResponseHandler
{

    String handle( HttpResponse httpResponse ) throws IOException;
}
