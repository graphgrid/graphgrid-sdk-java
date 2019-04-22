package com.graphgrid.sdk.model.distributor;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.graphgrid.sdk.core.model.GraphGridServiceRequest;

@JsonAutoDetect
@JsonIgnoreProperties( ignoreUnknown = true )
public class DistributorSavePolicyRequest extends GraphGridServiceRequest
{
    private DistributionPolicy distributionPolicy;
    private String clusterName;
    private String policyName;

    public DistributorSavePolicyRequest()
    {
    }

    public DistributorSavePolicyRequest( DistributionPolicy policy, String clusterName, String policyName )
    {
        this.distributionPolicy = policy;
        this.clusterName = clusterName;
        this.policyName = policyName;
    }

    public DistributionPolicy getDistributionPolicy()
    {
        return distributionPolicy;
    }

    public void setDistributionPolicy( DistributionPolicy distributionPolicy )
    {
        this.distributionPolicy = distributionPolicy;
    }

    public String getClusterName()
    {
        return clusterName;
    }

    public void setClusterName( String clusterName )
    {
        this.clusterName = clusterName;
    }

    public String getPolicyName()
    {
        return policyName;
    }

    public void setPolicyName( String policyName )
    {
        this.policyName = policyName;
    }
}
