package com.graphgrid.sdk.ml.model.spark.ml;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import javax.validation.constraints.NotBlank;

import com.graphgrid.sdk.ml.constant.PipelineStageType;
import com.graphgrid.sdk.ml.utils.PipelineStageDeserializer;

@JsonAutoDetect
@JsonInclude( JsonInclude.Include.NON_NULL )
@JsonTypeInfo( use = JsonTypeInfo.Id.NAME, property = "type", include = JsonTypeInfo.As.EXISTING_PROPERTY, visible = true)
@JsonSubTypes( {
        // Features
        @JsonSubTypes.Type( value = Transformer.class, name = PipelineStageType.INDEX_TO_STRING ),
        @JsonSubTypes.Type( value = Estimator.class, name = PipelineStageType.STRING_INDEXER ),
        @JsonSubTypes.Type( value = Transformer.class, name = PipelineStageType.VECTOR_ASSEMBLER ),
        @JsonSubTypes.Type( value = Estimator.class, name = PipelineStageType.WORD2VEC),
        @JsonSubTypes.Type( value = Transformer.class, name = PipelineStageType.TOKENIZER ),
        @JsonSubTypes.Type( value = Transformer.class, name = PipelineStageType.STOP_WORDS_REMOVER ),
        @JsonSubTypes.Type( value = Transformer.class, name = PipelineStageType.N_GRAM ),
        @JsonSubTypes.Type( value = Transformer.class, name = PipelineStageType.FEATURE_HASHER ),
        @JsonSubTypes.Type( value = Estimator.class, name = PipelineStageType.ONE_HOT_ENCODER_ESTIMATOR ),
        // Classification
        @JsonSubTypes.Type( value = Estimator.class, name = PipelineStageType.LOGISTIC_REGRESSION ),
        @JsonSubTypes.Type( value = Estimator.class, name = PipelineStageType.DECISION_TREE_CLASSIFIER ),
        @JsonSubTypes.Type( value = Estimator.class, name = PipelineStageType.RANDOM_FOREST_CLASSIFIER ),
        // Regression
        @JsonSubTypes.Type( value = Estimator.class, name = PipelineStageType.LINEAR_REGRESSION ),
        // Clustering
        @JsonSubTypes.Type( value = Estimator.class, name = PipelineStageType.KMEANS ),
        // Recommendation
        @JsonSubTypes.Type( value = Estimator.class, name = PipelineStageType.ALS )} )
@JsonDeserialize(using = PipelineStageDeserializer.class )
@Getter
@Setter
@EqualsAndHashCode
public abstract class PipelineStage
{

    @NotBlank
    protected String name;
    @JsonIgnore
    protected String pipelineType;
    @NotBlank
    protected String type;
    protected Map<String,Object> parameters;
    protected Map<String,String> outputs;

    public PipelineStage()
    {
        parameters = new HashMap<>();
        outputs = new HashMap<>();
    }
}
