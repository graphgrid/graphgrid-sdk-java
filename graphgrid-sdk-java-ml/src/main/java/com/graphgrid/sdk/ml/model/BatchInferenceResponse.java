package com.graphgrid.sdk.ml.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

import com.graphgrid.sdk.core.model.GraphGridServiceResponse;

@JsonAutoDetect
@Getter
@Setter
public class BatchInferenceResponse extends GraphGridServiceResponse
{

    private String jobId;
}
