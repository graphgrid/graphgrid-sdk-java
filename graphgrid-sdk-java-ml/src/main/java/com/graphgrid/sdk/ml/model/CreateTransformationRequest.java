package com.graphgrid.sdk.ml.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.graphgrid.sdk.core.model.GraphGridServiceRequest;
import com.graphgrid.sdk.ml.model.transformation.TransformationPolicy;

@JsonAutoDetect
@NoArgsConstructor
@Getter
@Setter
public class CreateTransformationRequest extends GraphGridServiceRequest
{

    private String clusterName;
    private TransformationPolicy policy;

    public CreateTransformationRequest( String clusterName, TransformationPolicy policy )
    {
        this.clusterName = clusterName;
        this.policy = policy;
    }
}
