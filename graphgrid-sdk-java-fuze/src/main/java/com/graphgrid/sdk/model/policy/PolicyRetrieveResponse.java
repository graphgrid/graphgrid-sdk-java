package com.graphgrid.sdk.model.policy;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.graphgrid.sdk.core.model.GraphGridServiceResponse;
import com.graphgrid.sdk.model.Policy;

@JsonAutoDetect
@JsonIgnoreProperties( ignoreUnknown = true )
public class PolicyRetrieveResponse extends GraphGridServiceResponse
{
    private Policy policy;

    public PolicyRetrieveResponse()
    {
    }

    public Policy getPolicy()
    {
        return policy;
    }

    public void setPolicy( Policy policy )
    {
        this.policy = policy;
    }
}
