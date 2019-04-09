package com.graphgrid.sdk.ml.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.graphgrid.sdk.core.model.GraphGridServiceRequest;
import com.graphgrid.sdk.ml.model.training.TrainingPolicy;

@JsonAutoDetect
@NoArgsConstructor
@Getter
@Setter
public class TrainModelRequest extends GraphGridServiceRequest
{

    private String clusterName;
    private TrainingPolicy policy;

    public TrainModelRequest( String clusterName, TrainingPolicy policy )
    {
        this.clusterName = clusterName;
        this.policy = policy;
    }
}
