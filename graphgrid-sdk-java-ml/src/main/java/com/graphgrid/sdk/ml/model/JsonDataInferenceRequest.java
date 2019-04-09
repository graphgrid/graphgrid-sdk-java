package com.graphgrid.sdk.ml.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.graphgrid.sdk.core.model.GraphGridServiceRequest;
import com.graphgrid.sdk.ml.model.inference.JsonDataInference;

@JsonAutoDetect
@NoArgsConstructor
@Getter
@Setter
public class JsonDataInferenceRequest extends GraphGridServiceRequest
{

    private String clusterName;
    private JsonDataInference jsonDataInference;

    public JsonDataInferenceRequest( String clusterName, JsonDataInference jsonDataInference )
    {
        this.clusterName = clusterName;
        this.jsonDataInference = jsonDataInference;
    }
}
