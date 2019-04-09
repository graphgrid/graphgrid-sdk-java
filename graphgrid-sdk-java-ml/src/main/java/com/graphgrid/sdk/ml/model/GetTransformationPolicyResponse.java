package com.graphgrid.sdk.ml.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;

import com.graphgrid.sdk.core.model.GraphGridServiceResponse;
import com.graphgrid.sdk.ml.model.transformation.TransformationPolicy;

@JsonAutoDetect
@NoArgsConstructor
@Getter
@Setter
public class GetTransformationPolicyResponse extends GraphGridServiceResponse
{

    private TransformationPolicy policy;

    public GetTransformationPolicyResponse( @Valid TransformationPolicy policy )
    {
        this.policy = policy;
    }
}
