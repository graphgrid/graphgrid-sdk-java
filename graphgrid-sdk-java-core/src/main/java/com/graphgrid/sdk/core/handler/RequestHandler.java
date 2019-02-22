package com.graphgrid.sdk.core.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphgrid.sdk.core.model.GraphGridServiceRequest;
import com.graphgrid.sdk.core.utils.HttpMethod;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;

import java.io.IOException;

public interface RequestHandler
{

    HttpResponse executeRequest( GraphGridServiceRequest ggRequest, HttpMethod httpMethod ) throws IOException;

    HttpResponse executeRequest( GraphGridServiceRequest ggRequest, HttpMethod httpMethod, HttpClient client ) throws IOException;

    HttpResponse executeRequest( GraphGridServiceRequest ggRequest, HttpMethod httpMethod, ObjectMapper objectMapper, HttpClient client ) throws IOException;
}
