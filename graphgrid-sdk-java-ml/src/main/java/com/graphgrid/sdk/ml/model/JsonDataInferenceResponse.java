package com.graphgrid.sdk.ml.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

import com.graphgrid.sdk.core.model.GraphGridServiceResponse;

@JsonAutoDetect
@Getter
@Setter
public class JsonDataInferenceResponse extends GraphGridServiceResponse
{

    private Map<String,Object> result;
}
