package com.graphgrid.sdk.core.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * can be used for testing and endpoints that dont require token authentication
 */
public class EmptySecurityConfigs extends SecurityConfig
{
    private static final Logger LOGGER = LoggerFactory.getLogger( EmptySecurityConfigs.class );

    public EmptySecurityConfigs()
    {
        LOGGER.warn( "Empty security configs are used. Should only be used for testing or endpoint that dont require authentication." );
    }
}
