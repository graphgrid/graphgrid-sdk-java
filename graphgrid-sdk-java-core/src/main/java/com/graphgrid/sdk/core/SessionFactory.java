package com.graphgrid.sdk.core;

import com.graphgrid.sdk.core.model.GraphGridServiceRequest;

/**
 * @author bradnussbaum
 */
public interface SessionFactory
{

    /**
     * Acquires token and additional request properties that can be used for monitoring purposes.
     */
    GraphGridServiceRequest addTokenToRequest( GraphGridServiceRequest request );

    /**
     * Only acquires token.
     */
    String getTokenFromRequest();
}
