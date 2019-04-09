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
public class GetBatchInferencePolicyRequest extends GraphGridServiceRequest
{

    private String clusterName;
    private String jobId;

    public GetBatchInferencePolicyRequest( String clusterName, String jobId )
    {
        this.clusterName = clusterName;
        this.jobId = jobId;
    }
}
