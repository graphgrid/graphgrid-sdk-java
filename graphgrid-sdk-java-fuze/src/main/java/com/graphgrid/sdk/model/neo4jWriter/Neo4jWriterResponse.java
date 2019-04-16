package com.graphgrid.sdk.model.neo4jWriter;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.graphgrid.sdk.core.model.GraphGridServiceResponse;

@JsonAutoDetect
@JsonIgnoreProperties( ignoreUnknown = true )
public class Neo4jWriterResponse extends GraphGridServiceResponse
{
    private TransactionResult transactionResult;

    public Neo4jWriterResponse()
    {
    }

    public TransactionResult getTransactionResult()
    {
        return transactionResult;
    }

    public void setTransactionResult( TransactionResult transactionResult )
    {
        this.transactionResult = transactionResult;
    }
}
