package com.graphgrid.sdk.ml.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.graphgrid.sdk.core.model.GraphGridServiceRequest;

@JsonAutoDetect
@NoArgsConstructor
@Getter
@Setter
public class GetInnerTransformationStatusRequest extends GraphGridServiceRequest
{

    private String clusterName;
    private String task;
    private String policyName;

    public GetInnerTransformationStatusRequest( String clusterName, String task, String policyName )
    {
        this.clusterName = clusterName;
        this.task = task;
        this.policyName = policyName;
    }
}
