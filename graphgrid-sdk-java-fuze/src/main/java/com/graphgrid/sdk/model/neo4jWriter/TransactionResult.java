package com.graphgrid.sdk.model.neo4jWriter;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;

@JsonAutoDetect
@JsonIgnoreProperties( ignoreUnknown = true )
public class TransactionResult
{
    private TransactionRequest transactionRequest;
    private List<Map<String,Object>> records;

    public TransactionResult()
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

    public List<Map<String,Object>> getRecords()
    {
        return records;
    }

    public void setRecords( List<Map<String,Object>> records )
    {
        this.records = records;
    }
}
