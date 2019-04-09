package com.graphgrid.sdk.ml.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import com.graphgrid.sdk.core.model.GraphGridServiceResponse;

@JsonAutoDetect
@JsonInclude( JsonInclude.Include.NON_NULL )
@Getter
@Setter
public class GetTransformationStatusResponse extends GraphGridServiceResponse
{

    private String task;
    private String policyName;
    private List<FeatureNodeTypeStats> featureNodeTypes;

    @JsonAutoDetect
    @Getter
    @Setter
    public static class FeatureNodeTypeStats
    {

        private List<String> nodeLabels;
        private int count;
        private List<String> features;
    }
}
