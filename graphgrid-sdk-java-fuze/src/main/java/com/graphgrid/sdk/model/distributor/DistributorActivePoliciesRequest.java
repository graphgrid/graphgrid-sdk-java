package com.graphgrid.sdk.model.distributor;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.graphgrid.sdk.core.model.GraphGridServiceRequest;

@JsonAutoDetect
@JsonIgnoreProperties( ignoreUnknown = true )
public class DistributorActivePoliciesRequest extends GraphGridServiceRequest
{
    private String clusterName;

    public DistributorActivePoliciesRequest()
    {
    }

    public DistributorActivePoliciesRequest( String clusterName )
    {
        this.clusterName = clusterName;
    }

    public String getClusterName()
    {
        return clusterName;
    }

    public void setClusterName( String clusterName )
    {
        this.clusterName = clusterName;
    }
}
