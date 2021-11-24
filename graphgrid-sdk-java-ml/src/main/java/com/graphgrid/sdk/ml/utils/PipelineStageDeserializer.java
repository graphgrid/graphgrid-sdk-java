package com.graphgrid.sdk.ml.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

import com.graphgrid.sdk.ml.constant.PipelineStageType;
import com.graphgrid.sdk.ml.model.MLPolicy;
import com.graphgrid.sdk.ml.model.inference.BatchInferencePolicy;
import com.graphgrid.sdk.ml.model.spark.ml.Estimator;
import com.graphgrid.sdk.ml.model.spark.ml.PipelineStage;
import com.graphgrid.sdk.ml.model.spark.ml.Transformer;
import com.graphgrid.sdk.ml.model.training.TrainingPolicy;
import com.graphgrid.sdk.ml.model.transformation.TransformationPolicy;

public class PipelineStageDeserializer extends JsonDeserializer<PipelineStage>
{
    /**
     * Deserialize SDK ML PipelineStage
     *
     * @param jsonParser
     * @param context
     * @return
     * @throws IOException
     */
    @Override
    public PipelineStage deserialize( JsonParser jsonParser, DeserializationContext context ) throws IOException
    {
        ObjectMapper objectMapper = (ObjectMapper) jsonParser.getCodec();
        ObjectNode root = objectMapper.readTree( jsonParser );
        if ( !root.has( "type" ) )
        {
            throw new IOException( "No [type] property when deserializing PipelineStage" );
        }
        JsonNode type = root.get( "type" );
        switch ( type.asText() )
        {
        case PipelineStageType.ALS:
        case PipelineStageType.DECISION_TREE_CLASSIFIER:
        case PipelineStageType.RANDOM_FOREST_CLASSIFIER:
        case PipelineStageType.KMEANS:
        case PipelineStageType.LINEAR_REGRESSION:
        case PipelineStageType.LOGISTIC_REGRESSION:
        case PipelineStageType.STRING_INDEXER:
        case PipelineStageType.WORD2VEC:
        case PipelineStageType.ONE_HOT_ENCODER_ESTIMATOR:
            return objectMapper.readValue( root.toString(), Estimator.class );
        case PipelineStageType.INDEX_TO_STRING:
        case PipelineStageType.VECTOR_ASSEMBLER:
        case PipelineStageType.TOKENIZER:
        case PipelineStageType.STOP_WORDS_REMOVER:
        case PipelineStageType.N_GRAM:
        case PipelineStageType.FEATURE_HASHER:
            return objectMapper.readValue( root.toString(), Transformer.class );
        default:
            throw new IllegalArgumentException( "[type] not recognized" );
        }

        // Each PipelineStage implementation must include at least one unique field. This is used to determine which type of PipelineStage to deserialize as.
//        if ( root.has( "fit" ) )
//        {
//            return objectMapper.readValue( root.toString(), Estimator.class );
//        }
//        else if ( root.has( "transform" ) )
//        {
//            return objectMapper.readValue( root.toString(), Transformer.class );
//        }
//        else
//        {
//            throw new IOException( "The PipelineStage that is being deserialized is not an SDK ML PipelineStage." );
//        }
    }
}
