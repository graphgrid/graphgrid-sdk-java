package com.graphgrid.sdk.model.neo4jWriter;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.graphgrid.sdk.core.model.GraphGridServiceRequest;

@JsonAutoDetect
@JsonIgnoreProperties( ignoreUnknown = true )
public class Neo4jWriterSavePolicyRequest extends GraphGridServiceRequest
{
    private Neo4jWriterPolicy policy;
    private String clusterName;
    private String policyName;

    public Neo4jWriterSavePolicyRequest()
    {
    }

    public Neo4jWriterSavePolicyRequest( Neo4jWriterPolicy policy, String clusterName, String policyName )
    {
        this.policy = policy;
        this.clusterName = clusterName;
        this.policyName = policyName;
    }

    public Neo4jWriterPolicy getPolicy()
    {
        return policy;
    }

    public void setPolicy( Neo4jWriterPolicy policy )
    {
        this.policy = policy;
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
