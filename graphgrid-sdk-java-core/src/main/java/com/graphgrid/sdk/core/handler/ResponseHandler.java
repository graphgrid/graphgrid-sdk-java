package com.graphgrid.sdk.core.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphgrid.sdk.core.model.GraphGridServiceResponse;
import org.apache.http.HttpResponse;

import java.io.IOException;

public interface ResponseHandler<T extends GraphGridServiceResponse>
{

    T handle( HttpResponse httpResponse, ObjectMapper mapper, Class<T> responseType ) throws IOException;

    T handle( HttpResponse httpResponse, Class<T> responseType ) throws IOException;

}
