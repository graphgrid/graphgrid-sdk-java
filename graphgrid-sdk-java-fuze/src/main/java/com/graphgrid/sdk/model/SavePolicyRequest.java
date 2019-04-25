package com.graphgrid.sdk.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.graphgrid.sdk.core.model.GraphGridServiceRequest;

@JsonAutoDetect
@JsonIgnoreProperties( ignoreUnknown = true )
public class SavePolicyRequest extends GraphGridServiceRequest
{
    private Policy policy;
    private String clusterName;
    private String policyName;

    public SavePolicyRequest()
    {
    }

    public SavePolicyRequest( Policy policy, String clusterName, String policyName )
    {
        this.policy = policy;
        this.clusterName = clusterName;
        this.policyName = policyName;
    }

    public Policy getPolicy()
    {
        return policy;
    }

    public void setPolicy( Policy policy )
    {
        this.policy = policy;
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
