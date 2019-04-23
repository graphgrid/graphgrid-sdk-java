package com.graphgrid.sdk.model.neo4jWriter;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.graphgrid.sdk.core.model.GraphGridServiceRequest;

@JsonAutoDetect
@JsonIgnoreProperties( ignoreUnknown = true )
public class Neo4jWriterRequest extends GraphGridServiceRequest
{
    private TransactionRequest transactionRequest;
    private String clusterName;
    private String policyName;

    public Neo4jWriterRequest()
    {
    }

    public Neo4jWriterRequest( TransactionRequest request )
    {
        this.transactionRequest = request;
    }

    public Neo4jWriterRequest( TransactionRequest request, String clusterName, String policyName )
    {
        this.transactionRequest = request;
        this.clusterName = clusterName;
        this.policyName = policyName;
    }

    public TransactionRequest getTransactionRequest()
    {
        return transactionRequest;
    }

    public void setTransactionRequest( TransactionRequest request )
    {
        this.transactionRequest = request;
    }

    public String getClusterName()
    {
        return clusterName;
    }

    public void setClusterName( String clusterName )
    {
        this.clusterName = clusterName;
    }

    public String getPolicyName()
    {
        return policyName;
    }

    public void setPolicyName( String policyName )
    {
        this.policyName = policyName;
    }
}
