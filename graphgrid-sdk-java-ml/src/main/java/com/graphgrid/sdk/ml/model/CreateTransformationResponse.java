package com.graphgrid.sdk.ml.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

import com.graphgrid.sdk.core.model.GraphGridServiceResponse;

@JsonAutoDetect
@Getter
@Setter
public class CreateTransformationResponse extends GraphGridServiceResponse
{

    private String policyName;
    private Map<String,Object> featureNodeCreation;
    private Map<String,Object> featureComputation;
}
