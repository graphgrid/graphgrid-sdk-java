package com.graphgrid.sdk.core.security;

/**
 * use when endpoint does not require token authentications
 * can also be useful for testing purpose
 */
public class NoTokenRequest implements RequestAuthMethod
{
    public NoTokenRequest()
    {
    }
}
