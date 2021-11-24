package com.graphgrid.sdk.ml.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

import com.graphgrid.sdk.ml.model.MLPolicy;
import com.graphgrid.sdk.ml.model.inference.BatchInferencePolicy;
import com.graphgrid.sdk.ml.model.training.TrainingPolicy;
import com.graphgrid.sdk.ml.model.transformation.TransformationPolicy;

public class PolicyDeserializer extends JsonDeserializer<MLPolicy>
{
    /**
     * Deserialize SDK ML Policy
     * @param jsonParser
     * @param context
     * @return
     * @throws IOException
     */
    @Override
    public MLPolicy deserialize( JsonParser jsonParser, DeserializationContext context ) throws IOException
    {
        ObjectMapper objectMapper = (ObjectMapper) jsonParser.getCodec();
        ObjectNode root = objectMapper.readTree( jsonParser );

        // Each Policy implementation must include at least one unique field. This is used to determine which type of Policy to deserialize as.
        if ( root.has( "source" ) )
        {
            return objectMapper.readValue( root.toString(), TransformationPolicy.class );
        }
        else if ( root.has( "trainingData" ) )
        {
            return objectMapper.readValue( root.toString(), TrainingPolicy.class );
        }
        else if ( root.has( "inputQuery" ) )
        {
            return objectMapper.readValue( root.toString(), BatchInferencePolicy.class );
        }
        else
        {
            throw new IOException( "The Policy that is being deserialized is not an SDK ML Policy." );
        }
    }
}
