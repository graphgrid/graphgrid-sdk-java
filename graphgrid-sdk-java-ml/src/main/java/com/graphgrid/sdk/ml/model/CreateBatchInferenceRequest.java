package com.graphgrid.sdk.ml.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.graphgrid.sdk.core.model.GraphGridServiceRequest;
import com.graphgrid.sdk.ml.model.inference.BatchInferencePolicy;

@JsonAutoDetect
@NoArgsConstructor
@Getter
@Setter
public class CreateBatchInferenceRequest extends GraphGridServiceRequest
{

    private String clusterName;
    private BatchInferencePolicy policy;

    public CreateBatchInferenceRequest( String clusterName, BatchInferencePolicy policy )
    {
        this.clusterName = clusterName;
        this.policy = policy;
    }
}
