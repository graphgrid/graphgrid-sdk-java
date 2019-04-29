package com.graphgrid.sdk.model.distributor;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;

import com.graphgrid.sdk.model.BrokerEndpoint;
import com.graphgrid.sdk.model.Neo4jCredentials;
import com.graphgrid.sdk.model.Policy;

@JsonAutoDetect
@JsonIgnoreProperties( ignoreUnknown = true )
public class DistributionPolicy implements Policy
{
    private Map<String,Object> metadata;

    private BrokerEndpoint listeningBrokerEndpoint;
    private List<ForwardingRule> forwardingRules;

    private Neo4jCredentials neo4jCredentials;

    public DistributionPolicy()
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

    public BrokerEndpoint getListeningBrokerEndpoint()
    {
        return listeningBrokerEndpoint;
    }

    public void setListeningBrokerEndpoint( BrokerEndpoint listeningBrokerEndpoint )
    {
        this.listeningBrokerEndpoint = listeningBrokerEndpoint;
    }

    public List<ForwardingRule> getForwardingRules()
    {
        return forwardingRules;
    }

    public void setForwardingRules( List<ForwardingRule> forwardingRules )
    {
        this.forwardingRules = forwardingRules;
    }

    public Neo4jCredentials getNeo4jCredentials()
    {
        return neo4jCredentials;
    }

    public void setNeo4jCredentials( Neo4jCredentials neo4jCredentials )
    {
        this.neo4jCredentials = neo4jCredentials;
    }

    @JsonAutoDetect
    @JsonIgnoreProperties( ignoreUnknown = true )
    public static class ForwardingRule
    {
        private String cypher;
        private Multicast multicast;

        public ForwardingRule()
        {
        }

        public String getCypher()
        {
            return cypher;
        }

        public void setCypher( String cypher )
        {
            this.cypher = cypher;
        }

        public Multicast getMulticast()
        {
            return multicast;
        }

        public void setMulticast( Multicast multicast )
        {
            this.multicast = multicast;
        }

        @JsonAutoDetect
        @JsonIgnoreProperties( ignoreUnknown = true )
        public static class Multicast
        {
            private int retry;
            private boolean stopOnFailure;
            private List<Map<String,String>> brokers;

            public Multicast()
            {
            }

            public int getRetry()
            {
                return retry;
            }

            public void setRetry( int retry )
            {
                this.retry = retry;
            }

            public boolean isStopOnFailure()
            {
                return stopOnFailure;
            }

            public void setStopOnFailure( boolean stopOnFailure )
            {
                this.stopOnFailure = stopOnFailure;
            }

            public List<Map<String,String>> getBrokers()
            {
                return brokers;
            }

            public void setBrokers( List<Map<String,String>> brokers )
            {
                this.brokers = brokers;
            }
        }
    }
}
