package com.graphgrid.sdk.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

import com.graphgrid.sdk.model.distributor.DistributionPolicy;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterPolicy;
import com.graphgrid.sdk.model.worker.WorkerPolicy;

public class PolicyDeserializer extends JsonDeserializer<Policy>
{
    @Override
    public Policy deserialize( JsonParser jsonParser, DeserializationContext context ) throws IOException
    {
        ObjectMapper objectMapper = (ObjectMapper) jsonParser.getCodec();
        ObjectNode root = objectMapper.readTree( jsonParser );

        // Each Policy implementation must include at least one unique field. This is used to determine which type of Policy to deserialize as.
        if ( root.has( "listeningBrokerEndpoint" ) )
        {
            return objectMapper.readValue( root.toString(), DistributionPolicy.class );
        }
        else if ( root.has( "defaultNeo4jCredentials" ) || root.has( "minBatchSize" ) || root.has( "maxBatchSize" ) || root.has( "listeningBrokerEndpoints" ) )
        {
            // Neo4jWriter policies may not necessarily have all these fields
            return objectMapper.readValue( root.toString(), Neo4jWriterPolicy.class );
        }
        else if ( root.has( "workers" ) )
        {
            return objectMapper.readValue( root.toString(), WorkerPolicy.class );
        }
        else
        {
            return objectMapper.readValue( root.toString(), Policy.class );
        }
    }
}
