package com.graphgrid.sdk.ml.model.training;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@JsonAutoDetect
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class TrainingData
{
    @NotBlank
    private String dataFrame;
    private double trainingRatio = 0.7;
}
