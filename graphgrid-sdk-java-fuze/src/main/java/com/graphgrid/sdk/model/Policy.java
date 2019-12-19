package com.graphgrid.sdk.model;

public interface Policy
{
    Metadata getMetadata();

    void setMetadata( Metadata metadata );

    Status getStatus();

    void setStatus( Status status );

    enum Status
    {
        INACTIVE,
        INACTIVE_WITH_ERROR,
        ACTIVE
    }
}
