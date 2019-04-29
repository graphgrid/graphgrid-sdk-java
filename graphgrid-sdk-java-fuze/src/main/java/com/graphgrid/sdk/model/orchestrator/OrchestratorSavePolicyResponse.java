package com.graphgrid.sdk.model.orchestrator;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.graphgrid.sdk.core.model.GraphGridServiceResponse;

@JsonAutoDetect
@JsonIgnoreProperties( ignoreUnknown = true )
public class OrchestratorSavePolicyResponse extends GraphGridServiceResponse
{
    private OrchestratorPolicy policy;

    public OrchestratorSavePolicyResponse()
    {
    }

    public OrchestratorPolicy getPolicy()
    {
        return policy;
    }

    public void setPolicy( OrchestratorPolicy policy )
    {
        this.policy = policy;
    }
}
