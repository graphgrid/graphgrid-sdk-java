package com.graphgrid.sdk.core.security;

/**
 * Use when endpoint does not require token authentications can also be useful for testing purpose.
 *
 * @author bradnussbaum
 */
public class NoTokenRequest implements RequestAuthMethod
{

    public NoTokenRequest()
    {
    }
}
