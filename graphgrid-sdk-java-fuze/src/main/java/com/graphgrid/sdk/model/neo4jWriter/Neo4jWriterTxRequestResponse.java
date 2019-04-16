package com.graphgrid.sdk.model.neo4jWriter;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.graphgrid.sdk.core.model.GraphGridServiceResponse;

@JsonAutoDetect
@JsonIgnoreProperties( ignoreUnknown = true )
public class Neo4jWriterTxRequestResponse extends GraphGridServiceResponse
{
    private TransactionRequest transactionRequest;

    public Neo4jWriterTxRequestResponse()
    {
    }

    public TransactionRequest getTransactionRequest()
    {
        return transactionRequest;
    }

    public void setTransactionRequest( TransactionRequest transactionRequest )
    {
        this.transactionRequest = transactionRequest;
    }
}
