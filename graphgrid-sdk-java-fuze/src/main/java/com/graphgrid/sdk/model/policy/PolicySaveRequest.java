package com.graphgrid.sdk.model.policy;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.graphgrid.sdk.core.model.GraphGridServiceRequest;
import com.graphgrid.sdk.model.Policy;

@JsonAutoDetect
@JsonIgnoreProperties( ignoreUnknown = true )
public class PolicySaveRequest extends GraphGridServiceRequest
{
    private String clusterName;
    private String policyName;
    private Policy policy;

    public PolicySaveRequest()
    {
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

    public Policy getPolicy()
    {
        return policy;
    }

    public void setPolicy( Policy policy )
    {
        this.policy = policy;
    }
}
