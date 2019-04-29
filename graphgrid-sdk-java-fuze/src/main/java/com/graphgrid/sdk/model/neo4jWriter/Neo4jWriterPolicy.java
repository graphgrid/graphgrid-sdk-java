package com.graphgrid.sdk.model.neo4jWriter;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;

import com.graphgrid.sdk.model.BrokerEndpoint;
import com.graphgrid.sdk.model.Neo4jCredentials;
import com.graphgrid.sdk.model.Policy;

@JsonAutoDetect
@JsonIgnoreProperties( ignoreUnknown = true )
public class Neo4jWriterPolicy implements Policy
{
    private Map<String,Object> metadata;

    private Neo4jCredentials defaultNeo4jCredentials;
    private List<BrokerEndpoint> listeningBrokerEndpoints;
    private Integer maxWriteAttempts;
    private Integer maxReadAttempts;
    private Integer minBatchSize;
    private Integer maxBatchSize;

    public Neo4jWriterPolicy()
    {
    }

    public Map<String,Object> getMetadata()
    {
        return metadata;
    }

    public void setMetadata( Map<String,Object> metadata )
    {
        this.metadata = metadata;
    }

    public Neo4jCredentials getDefaultNeo4jCredentials()
    {
        return defaultNeo4jCredentials;
    }

    public void setDefaultNeo4jCredentials( Neo4jCredentials defaultNeo4jCredentials )
    {
        this.defaultNeo4jCredentials = defaultNeo4jCredentials;
    }

    public List<BrokerEndpoint> getListeningBrokerEndpoints()
    {
        return listeningBrokerEndpoints;
    }

    public void setListeningBrokerEndpoints( List<BrokerEndpoint> listeningBrokerEndpoints )
    {
        this.listeningBrokerEndpoints = listeningBrokerEndpoints;
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
