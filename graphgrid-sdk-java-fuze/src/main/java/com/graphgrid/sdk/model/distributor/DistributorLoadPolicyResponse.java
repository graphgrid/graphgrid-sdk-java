package com.graphgrid.sdk.model.distributor;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.graphgrid.sdk.core.model.GraphGridServiceResponse;

@JsonAutoDetect
@JsonIgnoreProperties( ignoreUnknown = true )
public class DistributorLoadPolicyResponse extends GraphGridServiceResponse
{
    private DistributionPolicy policy;

    public DistributorLoadPolicyResponse()
    {
    }

    public DistributionPolicy getPolicy()
    {
        return policy;
    }

    public void setPolicy( DistributionPolicy policy )
    {
        this.policy = policy;
    }
}
