package com.graphgrid.sdk.model.distributor;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

import com.graphgrid.sdk.core.model.GraphGridServiceResponse;

@JsonAutoDetect
@JsonIgnoreProperties( ignoreUnknown = true )
public class DistributorActivePoliciesResponse extends GraphGridServiceResponse
{
    private List<DistributionPolicy> activePolicies;

    public DistributorActivePoliciesResponse()
    {
    }

    public List<DistributionPolicy> getActivePolicies()
    {
        return activePolicies;
    }

    public void setActivePolicies( List<DistributionPolicy> activePolicies )
    {
        this.activePolicies = activePolicies;
    }
}
