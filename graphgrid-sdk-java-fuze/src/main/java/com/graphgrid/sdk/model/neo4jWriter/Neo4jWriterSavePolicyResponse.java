package com.graphgrid.sdk.model.neo4jWriter;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.graphgrid.sdk.core.model.GraphGridServiceResponse;

@JsonAutoDetect
@JsonIgnoreProperties( ignoreUnknown = true )
public class Neo4jWriterSavePolicyResponse extends GraphGridServiceResponse
{
    private Neo4jWriterPolicy policy;

    public Neo4jWriterSavePolicyResponse()
    {
    }

    public Neo4jWriterPolicy getPolicy()
    {
        return policy;
    }

    public void setPolicy( Neo4jWriterPolicy policy )
    {
        this.policy = policy;
    }
}
