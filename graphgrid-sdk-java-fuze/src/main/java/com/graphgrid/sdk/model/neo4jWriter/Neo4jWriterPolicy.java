package com.graphgrid.sdk.model.neo4jWriter;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

import com.graphgrid.sdk.model.BrokerEndpoint;
import com.graphgrid.sdk.model.Metadata;
import com.graphgrid.sdk.model.Neo4jCredentials;
import com.graphgrid.sdk.model.Policy;

@JsonAutoDetect
@JsonTypeName( "neo4jWriterPolicy" )
@JsonIgnoreProperties( ignoreUnknown = true )
@JsonDeserialize( as = Neo4jWriterPolicy.class )
public class Neo4jWriterPolicy implements Policy
{
    private Metadata metadata;
    private Status status;

    private Neo4jCredentials defaultNeo4jCredentials;
    private List<BrokerEndpoint> txRequestBrokerEndpoints;
    private List<BrokerEndpoint> txDataBrokerEndpoints;
    private Integer maxWriteAttempts;
    private Integer maxReadAttempts;
    private Integer minBatchSize;
    private Integer maxBatchSize;

    public Neo4jWriterPolicy()
    {
    }

    @Override
    public Metadata getMetadata()
    {
        return metadata;
    }

    @Override
    public void setMetadata( Metadata metadata )
    {
        this.metadata = metadata;
    }

    @Override
    public Status getStatus()
    {
        return status;
    }

    @Override
    public void setStatus( Status status )
    {
        this.status = status;
    }

    public Neo4jCredentials getDefaultNeo4jCredentials()
    {
        return defaultNeo4jCredentials;
    }

    public void setDefaultNeo4jCredentials( Neo4jCredentials defaultNeo4jCredentials )
    {
        this.defaultNeo4jCredentials = defaultNeo4jCredentials;
    }

    public List<BrokerEndpoint> getTxRequestBrokerEndpoints()
    {
        return txRequestBrokerEndpoints;
    }

    public void setTxRequestBrokerEndpoints( List<BrokerEndpoint> txRequestBrokerEndpoints )
    {
        this.txRequestBrokerEndpoints = txRequestBrokerEndpoints;
    }

    public List<BrokerEndpoint> getTxDataBrokerEndpoints()
    {
        return txDataBrokerEndpoints;
    }

    public void setTxDataBrokerEndpoints( List<BrokerEndpoint> txDataBrokerEndpoints )
    {
        this.txDataBrokerEndpoints = txDataBrokerEndpoints;
    }

    public Integer getMaxWriteAttempts()
    {
        return maxWriteAttempts;
    }

    public void setMaxWriteAttempts( Integer maxWriteAttempts )
    {
        this.maxWriteAttempts = maxWriteAttempts;
    }

    public Integer getMaxReadAttempts()
    {
        return maxReadAttempts;
    }

    public void setMaxReadAttempts( Integer maxReadAttempts )
    {
        this.maxReadAttempts = maxReadAttempts;
    }

    public Integer getMinBatchSize()
    {
        return minBatchSize;
    }

    public void setMinBatchSize( Integer minBatchSize )
    {
        this.minBatchSize = minBatchSize;
    }

    public Integer getMaxBatchSize()
    {
        return maxBatchSize;
    }

    public void setMaxBatchSize( Integer maxBatchSize )
    {
        this.maxBatchSize = maxBatchSize;
    }
}
