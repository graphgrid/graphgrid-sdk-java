package com.graphgrid.sdk.ml.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.graphgrid.sdk.core.model.GraphGridServiceRequest;
import com.graphgrid.sdk.ml.model.inference.CypherDataInference;

@JsonAutoDetect
@NoArgsConstructor
@Getter
@Setter
public class CypherDataInferenceRequest extends GraphGridServiceRequest
{

    private String clusterName;
    private CypherDataInference cypherDataInference;

    public CypherDataInferenceRequest( String clusterName, CypherDataInference cypherDataInference )
    {
        this.clusterName = clusterName;
        this.cypherDataInference = cypherDataInference;
    }
}
