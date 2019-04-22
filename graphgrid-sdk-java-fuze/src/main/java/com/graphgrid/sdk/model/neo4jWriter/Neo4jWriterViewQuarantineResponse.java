package com.graphgrid.sdk.model.neo4jWriter;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

import com.graphgrid.sdk.core.model.GraphGridServiceResponse;

@JsonAutoDetect
@JsonIgnoreProperties( ignoreUnknown = true )
public class Neo4jWriterViewQuarantineResponse extends GraphGridServiceResponse
{
    private List<TransactionRequest> quarantine;

    public List<TransactionRequest> getQuarantine()
    {
        return quarantine;
    }

    public void setQuarantine( List<TransactionRequest> quarantine )
    {
        this.quarantine = quarantine;
    }
}
