package com.graphgrid.sdk.model.orchestrator;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

import com.graphgrid.sdk.core.model.GraphGridServiceResponse;
import com.graphgrid.sdk.model.worker.WorkerPolicy;

@JsonAutoDetect
@JsonIgnoreProperties( ignoreUnknown = true )
public class OrchestratorActivePoliciesResponse extends GraphGridServiceResponse
{
    private List<WorkerPolicy> activePolicies;

    public OrchestratorActivePoliciesResponse()
    {
    }

    public List<WorkerPolicy> getActivePolicies()
    {
        return activePolicies;
    }

    public void setActivePolicies( List<WorkerPolicy> activePolicies )
    {
        this.activePolicies = activePolicies;
    }
}
