package com.graphgrid.sdk.model.worker;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;

import com.graphgrid.sdk.model.BrokerEndpoint;
import com.graphgrid.sdk.model.Neo4jCredentials;
import com.graphgrid.sdk.model.Policy;

@JsonAutoDetect
@JsonIgnoreProperties( ignoreUnknown = true )
public class WorkerPolicy implements Policy
{
    private Map<String,Object> metadata;
    private Map<String,Worker> workers;
    private Neo4jCredentials defaultNeo4jCredentials;

    public WorkerPolicy()
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

    public Map<String,Worker> getWorkers()
    {
        return workers;
    }

    public void setWorkers( Map<String,Worker> workers )
    {
        this.workers = workers;
    }

    public Neo4jCredentials getDefaultNeo4jCredentials()
    {
        return defaultNeo4jCredentials;
    }

    public void setDefaultNeo4jCredentials( Neo4jCredentials defaultNeo4jCredentials )
    {
        this.defaultNeo4jCredentials = defaultNeo4jCredentials;
    }

    @JsonAutoDetect
    @JsonIgnoreProperties( ignoreUnknown = true )
    public class Worker
    {
        private Map<String,Object> metadata;

        private String cypher;
        private List<BrokerEndpoint> listeningEndpoints;
        private Neo4jCredentials neo4jCredentials;

        public Worker()
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

        public String getCypher()
        {
            return cypher;
        }

        public void setCypher( String cypher )
        {
            this.cypher = cypher;
        }

        public List<BrokerEndpoint> getListeningEndpoints()
        {
            return listeningEndpoints;
        }

        public void setListeningEndpoints( List<BrokerEndpoint> listeningEndpoints )
        {
            this.listeningEndpoints = listeningEndpoints;
        }

        public Neo4jCredentials getNeo4jCredentials()
        {
            return neo4jCredentials;
        }

        public void setNeo4jCredentials( Neo4jCredentials neo4jCredentials )
        {
            this.neo4jCredentials = neo4jCredentials;
        }
    }
}
