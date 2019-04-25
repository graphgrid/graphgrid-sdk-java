package com.graphgrid.sdk;

import com.graphgrid.sdk.model.ActivatePolicyRequest;
import com.graphgrid.sdk.model.ActivatePolicyResponse;
import com.graphgrid.sdk.model.DeactivatePolicyRequest;
import com.graphgrid.sdk.model.DeactivatePolicyResponse;
import com.graphgrid.sdk.model.DeletePolicyRequest;
import com.graphgrid.sdk.model.DeletePolicyResponse;
import com.graphgrid.sdk.model.FuzeServiceStatusRequest;
import com.graphgrid.sdk.model.FuzeServiceStatusResponse;
import com.graphgrid.sdk.model.LoadPolicyRequest;
import com.graphgrid.sdk.model.SavePolicyRequest;
import com.graphgrid.sdk.model.distributor.DistributorActivePoliciesRequest;
import com.graphgrid.sdk.model.distributor.DistributorActivePoliciesResponse;
import com.graphgrid.sdk.model.distributor.DistributorLoadPolicyResponse;
import com.graphgrid.sdk.model.distributor.DistributorPolicyStatusRequest;
import com.graphgrid.sdk.model.distributor.DistributorPolicyStatusResponse;
import com.graphgrid.sdk.model.distributor.DistributorSavePolicyResponse;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterAsyncResponse;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterBatchExecutionRequest;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterBatchExecutionResponse;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterDeleteQuarantineRequest;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterDeleteQuarantineResponse;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterLoadPolicyResponse;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterRequest;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterResponse;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterResultRequest;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterSavePolicyResponse;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterTxRequestResponse;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterTxRequestStatusResponse;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterViewQuarantineRequest;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterViewQuarantineResponse;
import com.graphgrid.sdk.model.orchestrator.OrchestratorLoadPolicyResponse;
import com.graphgrid.sdk.model.orchestrator.OrchestratorSavePolicyResponse;

public interface GraphGridFuze
{
    FuzeServiceStatusResponse status( FuzeServiceStatusRequest request );

    /////////////////
    // Neo4jWriter //
    /////////////////

    Neo4jWriterSavePolicyResponse saveNeo4jWriterPolicy( SavePolicyRequest request );

    Neo4jWriterLoadPolicyResponse loadNeo4jWriterPolicy( LoadPolicyRequest request );

    DeletePolicyResponse deleteNeo4jWriterPolicy( DeletePolicyRequest request );

    ActivatePolicyResponse activateNeo4jWriterPolicy( ActivatePolicyRequest request );

    DeactivatePolicyResponse deactivateNeo4jWriterPolicy( DeactivatePolicyRequest request );

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

    /////////////////
    // Distributor //
    /////////////////

    DistributorSavePolicyResponse saveDistributionPolicy( SavePolicyRequest request );

    DistributorLoadPolicyResponse loadDistributionPolicy( LoadPolicyRequest request );

    DeletePolicyResponse deleteDistributionPolicy( DeletePolicyRequest request );

    ActivatePolicyResponse activateDistributionPolicy( ActivatePolicyRequest request );

    DeactivatePolicyResponse deactivateDistributionPolicy( DeactivatePolicyRequest request );

    DistributorPolicyStatusResponse policyStatus( DistributorPolicyStatusRequest request );

    DistributorActivePoliciesResponse activeDistributionPolicies( DistributorActivePoliciesRequest request );

    //////////////////
    // Orchestrator //
    //////////////////

    OrchestratorSavePolicyResponse saveOrchestrationPolicy( SavePolicyRequest request );

    OrchestratorLoadPolicyResponse loadOrchestrationPolicy( LoadPolicyRequest request );

    DeletePolicyResponse deleteOrchestrationPolicy( DeletePolicyRequest request );

    ActivatePolicyResponse activateOrchestrationPolicy( ActivatePolicyRequest request );

    DeactivatePolicyResponse deactivateOrchestrationPolicy( DeactivatePolicyRequest request );
}
