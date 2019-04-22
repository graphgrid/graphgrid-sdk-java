package com.graphgrid.sdk.ml.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;

import com.graphgrid.sdk.core.model.GraphGridServiceResponse;
import com.graphgrid.sdk.ml.model.inference.BatchInferencePolicy;

@JsonAutoDetect
@NoArgsConstructor
@Getter
@Setter
public class GetBatchInferencePolicyResponse extends GraphGridServiceResponse
{

    private BatchInferencePolicy policy;

    public GetBatchInferencePolicyResponse( @Valid BatchInferencePolicy policy )
    {
        this.policy = policy;
    }
}
