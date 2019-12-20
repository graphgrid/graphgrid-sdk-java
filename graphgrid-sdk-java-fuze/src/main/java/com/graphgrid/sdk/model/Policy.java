package com.graphgrid.sdk.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize( using = PolicyDeserializer.class )
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
