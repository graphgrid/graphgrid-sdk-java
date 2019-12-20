package com.graphgrid.sdk.model.worker;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

import com.graphgrid.sdk.core.model.GraphGridServiceResponse;

@JsonAutoDetect
@JsonIgnoreProperties( ignoreUnknown = true )
public class WorkerActivePoliciesResponse extends GraphGridServiceResponse
{
    private List<WorkerPolicy> activePolicies;

    public WorkerActivePoliciesResponse()
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
