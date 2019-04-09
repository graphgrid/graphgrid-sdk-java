package com.graphgrid.sdk.ml.model.spark.ml;

import java.util.Arrays;

import com.graphgrid.sdk.ml.constant.EvaluatorType;

public class EvaluatorBuilder
{

    private Evaluator evaluator;

    public EvaluatorBuilder( String type )
    {
        switch ( type )
        {
        case EvaluatorType.BINARY_CLASSIFICATION:
        case EvaluatorType.CLUSTERING:
        case EvaluatorType.MULTICLASS_CLASSIFICATION:
        case EvaluatorType.REGRESSION:
            evaluator = new Evaluator();
            evaluator.setType( type );
            break;
        default:
            throw new IllegalArgumentException( "[type] not recognized" );
        }
    }

    public EvaluatorBuilder parameter( String field, Object value )
    {
        evaluator.getParameters().put( field, value );
        return this;
    }

    public EvaluatorBuilder metrics( String... metrics )
    {
        evaluator.getMetrics().addAll( Arrays.asList( metrics ) );
        return this;
    }

    public Evaluator build()
    {
        return evaluator;
    }
}
