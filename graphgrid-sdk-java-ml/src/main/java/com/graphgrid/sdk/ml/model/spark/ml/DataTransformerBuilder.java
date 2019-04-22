package com.graphgrid.sdk.ml.model.spark.ml;

public class DataTransformerBuilder
{

    private DataTransformer transform;

    public DataTransformerBuilder( String name, String dataFrame )
    {
        transform = new DataTransformer();
        transform.setName( name );
        transform.setDataFrame( dataFrame );
    }

    public DataTransformerBuilder output( String name, String field )
    {
        transform.getOutputs().put( name, field );
        return this;
    }

    public DataTransformer build()
    {
        return transform;
    }
}
