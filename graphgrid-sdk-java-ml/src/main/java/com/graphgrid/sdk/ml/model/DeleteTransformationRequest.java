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
public class DeleteTransformationRequest extends GraphGridServiceRequest
{

    private String clusterName;
    private String policyName;

    public DeleteTransformationRequest( String clusterName, String policyName )
    {
        this.clusterName = clusterName;
        this.policyName = policyName;
    }
}
