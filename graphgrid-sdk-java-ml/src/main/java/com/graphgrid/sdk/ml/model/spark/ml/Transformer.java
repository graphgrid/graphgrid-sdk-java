package com.graphgrid.sdk.ml.model.spark.ml;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;

import com.graphgrid.sdk.ml.constant.PipelineStageType;

@JsonAutoDetect
@JsonInclude( JsonInclude.Include.NON_NULL )
@Getter
@Setter
@EqualsAndHashCode
public class Transformer extends PipelineStage
{

    @Valid
    protected DataTransformer transform;

    public Transformer()
    {
        pipelineType = PipelineStageType.TRANSFORMER;
    }
}
