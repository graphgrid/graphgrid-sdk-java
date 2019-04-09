package com.graphgrid.sdk.ml.model.spark.ml;

public class DataFitterBuilder
{

    private DataFitter fit;

    public DataFitterBuilder( String name, String dataFrame )
    {
        fit = new DataFitter();
        fit.setName( name );
        fit.setDataFrame( dataFrame );
    }

    public DataFitterBuilder output( String name, String field )
    {
        fit.getOutputs().put( name, field );
        return this;
    }

    public DataFitterBuilder transform( DataTransformer transform )
    {
        fit.setTransform( transform );
        return this;
    }

    public DataFitter build()
    {
        return fit;
    }
}
