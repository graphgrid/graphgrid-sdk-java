package com.graphgrid.sdk.ml.model.training;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.graphgrid.sdk.ml.constant.PolicyType;
import com.graphgrid.sdk.ml.model.MLPolicy;
import com.graphgrid.sdk.ml.model.spark.ml.Evaluator;
import com.graphgrid.sdk.ml.model.spark.ml.PipelineStage;

@JsonAutoDetect
@JsonDeserialize( as = TrainingPolicy.class )
@JsonTypeName( PolicyType.TRAINING_POLICY )
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class TrainingPolicy extends MLPolicy
{

    private String task;
    @Valid
    @NotNull
    private DataFrameSource dataFrame;
    @Valid
    @NotEmpty
    private PipelineStage[] pipelineStages;
    @Valid
    @NotNull
    private TrainingData trainingData;
    @NotEmpty
    private String[] trainingPipelines;
    @Valid
    private Evaluator[] evaluators;
}
