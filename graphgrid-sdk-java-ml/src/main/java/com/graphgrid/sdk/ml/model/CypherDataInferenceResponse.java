package com.graphgrid.sdk.ml.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

import com.graphgrid.sdk.core.model.GraphGridServiceResponse;

@JsonAutoDetect
@Getter
@Setter
public class CypherDataInferenceResponse extends GraphGridServiceResponse
{

    private List<Map<String,Object>> results;
}
