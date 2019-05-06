package com.graphgrid.sdk.ml.model.spark.ml;

import com.graphgrid.sdk.ml.constant.PipelineStageType;

public class PipelineStageBuilder
{

    private PipelineStage pipelineStage;

    public PipelineStageBuilder( String name, String type )
    {
        switch ( type )
        {
        case PipelineStageType.ALS:
        case PipelineStageType.DECISION_TREE_CLASSIFIER:
        case PipelineStageType.KMEANS:
        case PipelineStageType.LINEAR_REGRESSION:
        case PipelineStageType.LOGISTIC_REGRESSION:
        case PipelineStageType.STRING_INDEXER:
        case PipelineStageType.WORD2VEC:
            pipelineStage = new Estimator();
            pipelineStage.setName( name );
            pipelineStage.setType( type );
            break;
        case PipelineStageType.INDEX_TO_STRING:
        case PipelineStageType.VECTOR_ASSEMBLER:
        case PipelineStageType.TOKENIZER:
        case PipelineStageType.STOP_WORDS_REMOVER:
            pipelineStage = new Transformer();
            pipelineStage.setName( name );
            pipelineStage.setType( type );
            break;
        default:
            throw new IllegalArgumentException( "[type] not recognized" );
        }
    }

    public PipelineStageBuilder parameter( String field, Object value )
    {
        pipelineStage.getParameters().put( field, value );
        return this;
    }

    public PipelineStageBuilder fit( DataFitter fit )
    {
        if ( !pipelineStage.getPipelineType().equals( PipelineStageType.ESTIMATOR ) )
        {
            throw new IllegalArgumentException( "[pipelineType] is not Estimator" );
        }
        ((Estimator) pipelineStage).setFit( fit );
        return this;
    }

    public PipelineStageBuilder transform( DataTransformer transform )
    {
        if ( !pipelineStage.getPipelineType().equals( PipelineStageType.TRANSFORMER ) )
        {
            throw new IllegalArgumentException( "[pipelineType] is not Transformer" );
        }
        ((Transformer) pipelineStage).setTransform( transform );
        return this;
    }

    public PipelineStageBuilder output( String name, String field )
    {
        pipelineStage.getOutputs().put( name, field );
        return this;
    }

    public PipelineStage build()
    {
        return pipelineStage;
    }
}
