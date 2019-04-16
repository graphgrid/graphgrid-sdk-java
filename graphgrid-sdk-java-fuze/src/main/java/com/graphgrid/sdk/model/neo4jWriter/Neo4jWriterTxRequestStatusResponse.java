package com.graphgrid.sdk.model.neo4jWriter;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.graphgrid.sdk.core.model.GraphGridServiceResponse;

@JsonAutoDetect
@JsonIgnoreProperties( ignoreUnknown = true )
public class Neo4jWriterTxRequestStatusResponse extends GraphGridServiceResponse
{
    private TransactionRequest.RequestStatus status;

    public TransactionRequest.RequestStatus getStatus()
    {
        return status;
    }

    public void setStatus( TransactionRequest.RequestStatus status )
    {
        this.status = status;
    }
}
