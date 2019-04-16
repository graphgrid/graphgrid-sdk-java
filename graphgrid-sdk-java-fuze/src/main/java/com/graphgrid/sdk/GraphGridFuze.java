package com.graphgrid.sdk;

import com.graphgrid.sdk.model.distributor.DistributorActivePoliciesRequest;
import com.graphgrid.sdk.model.distributor.DistributorActivePoliciesResponse;
import com.graphgrid.sdk.model.distributor.DistributorBrokerForwardingRequest;
import com.graphgrid.sdk.model.distributor.DistributorBrokerForwardingResponse;
import com.graphgrid.sdk.model.distributor.DistributorDeletePolicyRequest;
import com.graphgrid.sdk.model.distributor.DistributorDeletePolicyResponse;
import com.graphgrid.sdk.model.distributor.DistributorLoadPolicyRequest;
import com.graphgrid.sdk.model.distributor.DistributorLoadPolicyResponse;
import com.graphgrid.sdk.model.distributor.DistributorPolicyStatusRequest;
import com.graphgrid.sdk.model.distributor.DistributorPolicyStatusResponse;
import com.graphgrid.sdk.model.distributor.DistributorSavePolicyRequest;
import com.graphgrid.sdk.model.distributor.DistributorSavePolicyResponse;
import com.graphgrid.sdk.model.FuzeServiceStatusRequest;
import com.graphgrid.sdk.model.FuzeServiceStatusResponse;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterActivatePolicyRequest;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterActivatePolicyResponse;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterAsyncResponse;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterBatchExecutionRequest;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterBatchExecutionResponse;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterDeactivatePolicyRequest;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterDeactivatePolicyResponse;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterDeletePolicyRequest;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterDeletePolicyResponse;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterDeleteQuarantineRequest;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterDeleteQuarantineResponse;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterLoadPolicyRequest;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterLoadPolicyResponse;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterRequest;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterResponse;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterResultRequest;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterSavePolicyRequest;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterSavePolicyResponse;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterTxRequestResponse;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterTxRequestStatusResponse;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterViewQuarantineRequest;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterViewQuarantineResponse;

public interface GraphGridFuze
{
    FuzeServiceStatusResponse status( FuzeServiceStatusRequest request );

    // Neo4jWriter
    Neo4jWriterSavePolicyResponse saveNeo4jWriterPolicy( Neo4jWriterSavePolicyRequest request );

    Neo4jWriterLoadPolicyResponse loadNeo4jWriterPolicy( Neo4jWriterLoadPolicyRequest request );

    Neo4jWriterDeletePolicyResponse deleteNeo4jWriterPolicy( Neo4jWriterDeletePolicyRequest request );

    Neo4jWriterActivatePolicyResponse activateNeo4jWriterPolicy( Neo4jWriterActivatePolicyRequest request );

    Neo4jWriterDeactivatePolicyResponse deactivateNeo4jWriterPolicy( Neo4jWriterDeactivatePolicyRequest request );

    Neo4jWriterResponse write( Neo4jWriterRequest request );

    Neo4jWriterAsyncResponse writeAsync( Neo4jWriterRequest request );

    Neo4jWriterResponse read( Neo4jWriterRequest request );

    Neo4jWriterAsyncResponse readAsync( Neo4jWriterRequest request );

    Neo4jWriterAsyncResponse queueRequestForBatching( Neo4jWriterRequest request );

    Neo4jWriterBatchExecutionResponse batchAndExecuteQueuedRequests( Neo4jWriterBatchExecutionRequest request );

    Neo4jWriterResponse getTransactionResult( Neo4jWriterResultRequest request );

    Neo4jWriterTxRequestResponse getTransactionRequest( Neo4jWriterResultRequest request );

    Neo4jWriterTxRequestStatusResponse getTransactionRequestStatus( Neo4jWriterResultRequest request );

    Neo4jWriterViewQuarantineResponse viewQuarantine( Neo4jWriterViewQuarantineRequest request );

    Neo4jWriterDeleteQuarantineResponse clearQuarantine( Neo4jWriterDeleteQuarantineRequest request );

    // Distributor
    DistributorSavePolicyResponse saveDistributionPolicy( DistributorSavePolicyRequest request );

    DistributorLoadPolicyResponse loadDistributionPolicy( DistributorLoadPolicyRequest request );

    DistributorDeletePolicyResponse deleteDistributionPolicy( DistributorDeletePolicyRequest request );

    DistributorBrokerForwardingResponse startBrokerForwarding( DistributorBrokerForwardingRequest request );

    DistributorBrokerForwardingResponse stopBrokerForwarding( DistributorBrokerForwardingRequest request );

    DistributorPolicyStatusResponse policyStatus( DistributorPolicyStatusRequest request );

    DistributorActivePoliciesResponse activeDistributionPolicies( DistributorActivePoliciesRequest request );
}
