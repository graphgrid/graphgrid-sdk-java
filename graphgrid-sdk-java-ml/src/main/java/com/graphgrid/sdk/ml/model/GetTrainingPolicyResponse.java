package com.graphgrid.sdk.ml.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;

import com.graphgrid.sdk.core.model.GraphGridServiceResponse;
import com.graphgrid.sdk.ml.model.training.TrainingPolicy;

@JsonAutoDetect
@NoArgsConstructor
@Getter
@Setter
public class GetTrainingPolicyResponse extends GraphGridServiceResponse
{

    private TrainingPolicy policy;

    public GetTrainingPolicyResponse( @Valid TrainingPolicy policy )
    {
        this.policy = policy;
    }
}
