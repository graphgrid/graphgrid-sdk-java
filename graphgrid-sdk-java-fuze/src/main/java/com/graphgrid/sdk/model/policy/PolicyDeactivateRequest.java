package com.graphgrid.sdk.model.policy;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.graphgrid.sdk.core.model.GraphGridServiceRequest;

@JsonAutoDetect
@JsonIgnoreProperties( ignoreUnknown = true )
public class PolicyDeactivateRequest extends GraphGridServiceRequest
{
    private String clusterName;
    private String policyName;

    public PolicyDeactivateRequest()
    {
    }

    public PolicyDeactivateRequest( String clusterName, String policyName )
    {
        this.clusterName = clusterName;
        this.policyName = policyName;
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
