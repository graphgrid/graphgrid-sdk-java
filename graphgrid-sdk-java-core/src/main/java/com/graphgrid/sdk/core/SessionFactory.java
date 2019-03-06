package com.graphgrid.sdk.core;

import com.graphgrid.sdk.core.model.GraphGridServiceRequest;

public interface SessionFactory
{

    /**
     * acquires token and additional request properties that can be used for monitoring purposes
     *
     * @param request
     * @return
     */
    GraphGridServiceRequest addTokenToRequest( GraphGridServiceRequest request );

    /**
     * only acquires token
     *
     * @return
     */
    String getTokenFromRequest();

}
