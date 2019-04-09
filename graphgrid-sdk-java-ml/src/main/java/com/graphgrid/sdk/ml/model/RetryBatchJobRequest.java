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
public class RetryBatchJobRequest extends GraphGridServiceRequest
{

    private String clusterName;
    private String jobId;
    private BatchInferencePolicy policy;

    public RetryBatchJobRequest( String clusterName, String jobId, BatchInferencePolicy policy )
    {
        this.clusterName = clusterName;
        this.jobId = jobId;
        this.policy = policy;
    }
}
