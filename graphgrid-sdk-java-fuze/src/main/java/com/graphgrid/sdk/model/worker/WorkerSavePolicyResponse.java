package com.graphgrid.sdk.model.worker;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.graphgrid.sdk.core.model.GraphGridServiceResponse;

@JsonAutoDetect
@JsonIgnoreProperties( ignoreUnknown = true )
public class WorkerSavePolicyResponse extends GraphGridServiceResponse
{
    private WorkerPolicy policy;

    public WorkerSavePolicyResponse()
    {
    }

    public WorkerPolicy getPolicy()
    {
        return policy;
    }

    public void setPolicy( WorkerPolicy policy )
    {
        this.policy = policy;
    }
}
