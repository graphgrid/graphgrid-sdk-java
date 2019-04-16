package com.graphgrid.sdk.model.neo4jWriter;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

import com.graphgrid.sdk.core.model.GraphGridServiceResponse;

@JsonAutoDetect
@JsonIgnoreProperties( ignoreUnknown = true )
public class Neo4jWriterAsyncResponse extends GraphGridServiceResponse
{
    private String fuzeId;

    public String getFuzeId()
    {
        return fuzeId;
    }

    public void setFuzeId( String fuzeId )
    {
        this.fuzeId = fuzeId;
    }
}
