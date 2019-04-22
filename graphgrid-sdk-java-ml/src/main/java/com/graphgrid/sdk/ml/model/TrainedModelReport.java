package com.graphgrid.sdk.ml.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

import com.graphgrid.sdk.core.model.GraphGridServiceResponse;
import com.graphgrid.sdk.ml.model.dataframe.ColumnSchema;

@JsonAutoDetect
@Getter
@Setter
public class TrainedModelReport extends GraphGridServiceResponse
{

    private String task;
    private String policyName;
    private String grn;
    private String createdAt;
    private String updatedAt;
    private List<String> pipelineStages;
    private Long trainingDataCount;
    private Long testDataCount;
    private List<ColumnSchema> inputSchema;
    private List<ColumnSchema> outputSchema;
    private Map<String,Double> metrics;
}
