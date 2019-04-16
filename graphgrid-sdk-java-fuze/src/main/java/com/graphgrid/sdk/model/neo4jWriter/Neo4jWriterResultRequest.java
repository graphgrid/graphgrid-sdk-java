package com.graphgrid.sdk.model.neo4jWriter;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.graphgrid.sdk.core.model.GraphGridServiceRequest;

@JsonAutoDetect
@JsonIgnoreProperties( ignoreUnknown = true )
public class Neo4jWriterResultRequest extends GraphGridServiceRequest
{
    private String fuzeId;

    public Neo4jWriterResultRequest()
    {
    }

    public Neo4jWriterResultRequest( String fuzeId )
    {
        this.fuzeId = fuzeId;
    }

    public String getFuzeId()
    {
        return fuzeId;
    }

    public void setFuzeId( String fuzeId )
    {
        this.fuzeId = fuzeId;
    }
}
