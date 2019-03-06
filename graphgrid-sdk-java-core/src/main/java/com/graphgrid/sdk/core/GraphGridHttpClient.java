package com.graphgrid.sdk.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphgrid.sdk.core.exception.GraphGridSdkException;
import com.graphgrid.sdk.core.handler.JsonRequestHandler;
import com.graphgrid.sdk.core.handler.JsonResponseHandler;
import com.graphgrid.sdk.core.handler.RequestHandler;
import com.graphgrid.sdk.core.handler.ResponseHandler;
import com.graphgrid.sdk.core.model.GraphGridServiceRequest;
import com.graphgrid.sdk.core.model.GraphGridServiceResponse;
import com.graphgrid.sdk.core.utils.HttpMethod;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static com.graphgrid.sdk.core.utils.Preconditions.checkNotNull;

/**
 * handles making http request to graph grid rest endpoint
 */
public class GraphGridHttpClient
{

    private static final Logger LOGGER = LoggerFactory.getLogger( GraphGridHttpClient.class );

    private ObjectMapper objectMapper;

    private HttpClient apacheClient;

    public GraphGridHttpClient()
    {
        this( new ObjectMapper(), HttpClientBuilder.create().build() );
    }

    public GraphGridHttpClient( ObjectMapper objectMapper, HttpClient client )
    {
        this.objectMapper = checkNotNull( objectMapper, "objectMapper" );
        this.apacheClient = checkNotNull( client, "client" );
    }

    public <T extends GraphGridServiceResponse> T invoke( GraphGridServiceRequest ggRequest, Class<T> responseType, HttpMethod httpMethod )
    {
        IOException ex = null;
        try
        {
            return (T) processResponse( ggRequest.getResponseHandler(), executeRequest( ggRequest.getRequestHandler(), ggRequest, httpMethod ), objectMapper,
                    responseType );
        }
        catch ( IOException e )
        {
            LOGGER.error( "error processing request " + ggRequest.toString(), e.getMessage() );
            ex = e;
        }
        throw new GraphGridSdkException( "error processing request " + ggRequest.toString(), ex );
    }


    public <T extends GraphGridServiceResponse> T processResponse( ResponseHandler handler, HttpResponse httpResponse, ObjectMapper mapper, Class<T> responseType ) throws IOException
    {
        if ( handler == null && mapper == null )
        {
            return (T) new JsonResponseHandler().handle( httpResponse, objectMapper, responseType );
        }
        else if ( handler != null && mapper == null )
        {
            return (T) handler.handle( httpResponse, objectMapper, responseType );
        }
        else if ( handler == null && mapper != null )
        {
            return (T) new JsonResponseHandler().handle( httpResponse, mapper, responseType );
        }
        else
        {
            return (T) handler.handle( httpResponse, mapper, responseType );
        }
    }

    private HttpResponse executeRequest( RequestHandler handler, GraphGridServiceRequest request, HttpMethod httpMethod ) throws IOException
    {
        if ( handler == null )
        {
            return new JsonRequestHandler().executeRequest( request, httpMethod, this.apacheClient );
        }
        else
        {
            return request.getRequestHandler().executeRequest( request, httpMethod, this.apacheClient );
        }
    }
}
