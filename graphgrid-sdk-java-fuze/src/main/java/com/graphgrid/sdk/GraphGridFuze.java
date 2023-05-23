package com.graphgrid.sdk;

import com.graphgrid.sdk.model.FuzeServiceStatusRequest;
import com.graphgrid.sdk.model.FuzeServiceStatusResponse;
import com.graphgrid.sdk.model.distributor.DistributorActivePoliciesRequest;
import com.graphgrid.sdk.model.distributor.DistributorActivePoliciesResponse;
import com.graphgrid.sdk.model.distributor.DistributorPolicyStatusRequest;
import com.graphgrid.sdk.model.distributor.DistributorPolicyStatusResponse;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterActivePoliciesRequest;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterActivePoliciesResponse;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterAsyncResponse;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterBatchExecutionRequest;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterBatchExecutionResponse;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterClearQuarantineRequest;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterClearQuarantineResponse;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterRequest;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterResponse;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterResultRequest;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterTxRequestResponse;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterTxRequestStatusResponse;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterViewQuarantineRequest;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterViewQuarantineResponse;
import com.graphgrid.sdk.model.orchestrator.OrchestratorActivePoliciesRequest;
import com.graphgrid.sdk.model.orchestrator.OrchestratorActivePoliciesResponse;
import com.graphgrid.sdk.model.policy.PolicyActivateRequest;
import com.graphgrid.sdk.model.policy.PolicyActivateResponse;
import com.graphgrid.sdk.model.policy.PolicyDeactivateRequest;
import com.graphgrid.sdk.model.policy.PolicyDeactivateResponse;
import com.graphgrid.sdk.model.policy.PolicyDeleteRequest;
import com.graphgrid.sdk.model.policy.PolicyDeleteResponse;
import com.graphgrid.sdk.model.policy.PolicyRetrieveRequest;
import com.graphgrid.sdk.model.policy.PolicyRetrieveResponse;
import com.graphgrid.sdk.model.policy.PolicySaveRequest;
import com.graphgrid.sdk.model.policy.PolicySaveResponse;
import com.graphgrid.sdk.model.worker.WorkerActivePoliciesRequest;
import com.graphgrid.sdk.model.worker.WorkerActivePoliciesResponse;

public interface GraphGridFuze
{

    FuzeServiceStatusResponse status( FuzeServiceStatusRequest request );

    ///////////////////////
    // Policy Management //
    ///////////////////////

    PolicySaveResponse savePolicy( PolicySaveRequest request );

    PolicyRetrieveResponse retrievePolicy( PolicyRetrieveRequest request );

    PolicyDeleteResponse deletePolicy( PolicyDeleteRequest request );

    PolicyActivateResponse activatePolicy( PolicyActivateRequest request );

    PolicyDeactivateResponse deactivatePolicy( PolicyDeactivateRequest request );

    /////////////////
    // Neo4jWriter //
    /////////////////

    Neo4jWriterActivePoliciesResponse activeNeo4jWriterPolicies( Neo4jWriterActivePoliciesRequest request );

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

    Neo4jWriterClearQuarantineResponse clearQuarantine( Neo4jWriterClearQuarantineRequest request );

    /////////////////
    // Distributor //
    /////////////////

    DistributorPolicyStatusResponse policyStatus( DistributorPolicyStatusRequest request );

    DistributorActivePoliciesResponse activeDistributionPolicies( DistributorActivePoliciesRequest request );

    /////////////////
    // Fuze Worker //
    /////////////////

    WorkerActivePoliciesResponse activeWorkerPolicies( WorkerActivePoliciesRequest request );

    //////////////////
    // Orchestrator //
    //////////////////

    OrchestratorActivePoliciesResponse activeOrchestratorPolicies( OrchestratorActivePoliciesRequest request );
}
