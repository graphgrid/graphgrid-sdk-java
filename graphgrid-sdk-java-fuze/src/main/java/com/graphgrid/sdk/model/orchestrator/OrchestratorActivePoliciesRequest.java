package com.graphgrid.sdk.model.orchestrator;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.graphgrid.sdk.core.model.GraphGridServiceRequest;

@JsonAutoDetect
@JsonIgnoreProperties( ignoreUnknown = true )
public class OrchestratorActivePoliciesRequest extends GraphGridServiceRequest
{
    private String clusterName;

    public OrchestratorActivePoliciesRequest()
    {
    }

    public String getClusterName()
    {
        return clusterName;
    }

    public void setClusterName( String clusterName )
    {
        this.clusterName = clusterName;
    }
}
