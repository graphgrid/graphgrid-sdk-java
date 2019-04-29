package com.graphgrid.sdk;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.graphgrid.sdk.core.GraphGridSecurityClientBase;
import com.graphgrid.sdk.core.SessionFactory;
import com.graphgrid.sdk.core.model.GraphGridServiceRequest;
import com.graphgrid.sdk.core.model.GraphGridServiceResponse;
import com.graphgrid.sdk.core.security.SecurityConfig;
import com.graphgrid.sdk.core.utils.HttpMethod;
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
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterClearQuarantineRequest;
import com.graphgrid.sdk.model.neo4jWriter.Neo4jWriterClearQuarantineResponse;
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
import com.graphgrid.sdk.model.worker.WorkerLoadPolicyResponse;
import com.graphgrid.sdk.model.worker.WorkerSavePolicyResponse;
import com.graphgrid.sdk.support.Endpoints;

public class GraphGridFuzeClient extends GraphGridSecurityClientBase implements GraphGridFuze
{
    private static final Logger LOGGER = LoggerFactory.getLogger( GraphGridFuzeClient.class );

    public GraphGridFuzeClient( String serviceBaseUrl )
    {
        super( serviceBaseUrl );
    }

    public GraphGridFuzeClient( String serviceBaseUrl, SecurityConfig securityConfig )
    {
        super( serviceBaseUrl, securityConfig );
    }

    public GraphGridFuzeClient( String serviceBaseUrl, SecurityConfig securityConfig, SessionFactory sessionFactory )
    {
        super( serviceBaseUrl, securityConfig, sessionFactory );
    }

    @Override
    public FuzeServiceStatusResponse status( final FuzeServiceStatusRequest request )
    {
        request.setEndpoint( getEndpointBuilder().create( request ).withServiceEndpoint( Endpoints.STATUS ).buildUrl() );
        return makeRequest( request, FuzeServiceStatusResponse.class, HttpMethod.GET );
    }

    /////////////////
    // Neo4jWriter //
    /////////////////

    @Override
    public Neo4jWriterSavePolicyResponse saveNeo4jWriterPolicy( SavePolicyRequest request )
    {
        request.setEndpoint( getEndpointBuilder().create( request ).addPathVariable( request.getClusterName() )
                .addPathVariable( Endpoints.SAVE_NEO4J_WRITER_POLICY ).addPathVariable( request.getPolicyName() ).buildUrl() );
        request.setBody( request.getPolicy() );
        return makeRequest( request, Neo4jWriterSavePolicyResponse.class, HttpMethod.POST );
    }

    @Override
    public Neo4jWriterLoadPolicyResponse loadNeo4jWriterPolicy( LoadPolicyRequest request )
    {
        request.setEndpoint( getEndpointBuilder().create( request ).addPathVariable( request.getClusterName() )
                .addPathVariable( Endpoints.LOAD_NEO4J_WRITER_POLICY ).addPathVariable( request.getPolicyName() ).buildUrl() );
        return makeRequest( request, Neo4jWriterLoadPolicyResponse.class, HttpMethod.GET );
    }

    @Override
    public DeletePolicyResponse deleteNeo4jWriterPolicy( DeletePolicyRequest request )
    {
        request.setEndpoint( getEndpointBuilder().create( request ).addPathVariable( request.getClusterName() )
                .addPathVariable( Endpoints.DELETE_NEO4J_WRITER_POLICY ).addPathVariable( request.getPolicyName() ).buildUrl() );
        return makeRequest( request, DeletePolicyResponse.class, HttpMethod.DELETE );
    }

    @Override
    public ActivatePolicyResponse activateNeo4jWriterPolicy( ActivatePolicyRequest request )
    {
        request.setEndpoint( getEndpointBuilder().create( request ).addPathVariable( request.getClusterName() )
                .addPathVariable( Endpoints.ACTIVATE_NEO4J_WRITER_POLICY ).addPathVariable( request.getPolicyName() ).buildUrl() );
        return makeRequest( request, ActivatePolicyResponse.class, HttpMethod.POST );
    }

    @Override
    public DeactivatePolicyResponse deactivateNeo4jWriterPolicy( DeactivatePolicyRequest request )
    {
        request.setEndpoint( getEndpointBuilder().create( request ).addPathVariable( request.getClusterName() )
                .addPathVariable( Endpoints.DEACTIVATE_NEO4J_WRITER_POLICY ).addPathVariable( request.getPolicyName() ).buildUrl() );
        return makeRequest( request, DeactivatePolicyResponse.class, HttpMethod.POST );
    }

    @Override
    public Neo4jWriterResponse write( final Neo4jWriterRequest request )
    {
        if ( !StringUtils.isEmpty( request.getClusterName() ) && !StringUtils.isEmpty( request.getPolicyName() ) )
        {
            request.setEndpoint( getEndpointBuilder().create( request ).addPathVariable( request.getClusterName() ).addPathVariable( Endpoints.WRITE )
                    .addPathVariable( request.getPolicyName() ).buildUrl() );
        }
        else
        {
            request.setEndpoint( getEndpointBuilder().create( request ).withServiceEndpoint( Endpoints.WRITE ).buildUrl() );
        }
        request.setBody( request.getTransactionRequest() );
        return makeRequest( request, Neo4jWriterResponse.class, HttpMethod.POST );
    }

    @Override
    public Neo4jWriterAsyncResponse writeAsync( final Neo4jWriterRequest request )
    {
        if ( !StringUtils.isEmpty( request.getClusterName() ) && !StringUtils.isEmpty( request.getPolicyName() ) )
        {
            request.setEndpoint( getEndpointBuilder().create( request ).addPathVariable( request.getClusterName() ).addPathVariable( Endpoints.WRITE_ASYNC )
                    .addPathVariable( request.getPolicyName() ).buildUrl() );
        }
        else
        {
            request.setEndpoint( getEndpointBuilder().create( request ).withServiceEndpoint( Endpoints.WRITE_ASYNC ).buildUrl() );
        }
        request.setBody( request.getTransactionRequest() );
        return makeRequest( request, Neo4jWriterAsyncResponse.class, HttpMethod.POST );
    }

    @Override
    public Neo4jWriterResponse read( final Neo4jWriterRequest request )
    {
        if ( !StringUtils.isEmpty( request.getClusterName() ) && !StringUtils.isEmpty( request.getPolicyName() ) )
        {
            request.setEndpoint( getEndpointBuilder().create( request ).addPathVariable( request.getClusterName() ).addPathVariable( Endpoints.READ )
                    .addPathVariable( request.getPolicyName() ).buildUrl() );
        }
        else
        {
            request.setEndpoint( getEndpointBuilder().create( request ).withServiceEndpoint( Endpoints.READ ).buildUrl() );
        }
        request.setBody( request.getTransactionRequest() );
        return makeRequest( request, Neo4jWriterResponse.class, HttpMethod.POST );
    }

    @Override
    public Neo4jWriterAsyncResponse readAsync( final Neo4jWriterRequest request )
    {
        if ( !StringUtils.isEmpty( request.getClusterName() ) && !StringUtils.isEmpty( request.getPolicyName() ) )
        {
            request.setEndpoint( getEndpointBuilder().create( request ).addPathVariable( request.getClusterName() ).addPathVariable( Endpoints.READ_ASYNC )
                    .addPathVariable( request.getPolicyName() ).buildUrl() );
        }
        else
        {
            request.setEndpoint( getEndpointBuilder().create( request ).withServiceEndpoint( Endpoints.READ_ASYNC ).buildUrl() );
        }
        request.setBody( request.getTransactionRequest() );
        return makeRequest( request, Neo4jWriterAsyncResponse.class, HttpMethod.POST );
    }

    @Override
    public Neo4jWriterAsyncResponse queueRequestForBatching( final Neo4jWriterRequest request )
    {
        if ( !StringUtils.isEmpty( request.getClusterName() ) && !StringUtils.isEmpty( request.getPolicyName() ) )
        {
            request.setEndpoint( getEndpointBuilder().create( request ).addPathVariable( request.getClusterName() )
                    .addPathVariable( Endpoints.QUEUE_REQUEST_FOR_BATCHING ).addPathVariable( request.getPolicyName() ).buildUrl() );
        }
        else
        {
            request.setEndpoint( getEndpointBuilder().create( request ).withServiceEndpoint( Endpoints.QUEUE_REQUEST_FOR_BATCHING ).buildUrl() );
        }
        request.setBody( request.getTransactionRequest() );
        return makeRequest( request, Neo4jWriterAsyncResponse.class, HttpMethod.POST );
    }

    @Override
    public Neo4jWriterBatchExecutionResponse batchAndExecuteQueuedRequests( final Neo4jWriterBatchExecutionRequest request )
    {
        if ( !StringUtils.isEmpty( request.getClusterName() ) && !StringUtils.isEmpty( request.getPolicyName() ) )
        {
            request.setEndpoint( getEndpointBuilder().create( request ).addPathVariable( request.getClusterName() )
                    .addPathVariable( Endpoints.BATCH_AND_EXECUTE_QUEUED_REQUESTS ).addPathVariable( request.getPolicyName() ).buildUrl() );
        }
        else
        {
            request.setEndpoint( getEndpointBuilder().create( request ).withServiceEndpoint( Endpoints.BATCH_AND_EXECUTE_QUEUED_REQUESTS ).buildUrl() );
        }
        return makeRequest( request, Neo4jWriterBatchExecutionResponse.class, HttpMethod.POST );
    }

    @Override
    public Neo4jWriterResponse getTransactionResult( final Neo4jWriterResultRequest request )
    {
        request.setEndpoint( getEndpointBuilder().create( request ).withServiceEndpoint( Endpoints.GET_TRANSACTION_RESULT )
                .addQueryParam( "fuzeId", request.getFuzeId() ).buildUrl() );
        return makeRequest( request, Neo4jWriterResponse.class, HttpMethod.GET );
    }

    @Override
    public Neo4jWriterTxRequestResponse getTransactionRequest( final Neo4jWriterResultRequest request )
    {
        request.setEndpoint( getEndpointBuilder().create( request ).withServiceEndpoint( Endpoints.GET_TRANSACTION_REQUEST )
                .addQueryParam( "fuzeId", request.getFuzeId() ).buildUrl() );
        return makeRequest( request, Neo4jWriterTxRequestResponse.class, HttpMethod.GET );
    }

    @Override
    public Neo4jWriterTxRequestStatusResponse getTransactionRequestStatus( final Neo4jWriterResultRequest request )
    {
        request.setEndpoint( getEndpointBuilder().create( request ).withServiceEndpoint( Endpoints.CHECK_TRANSACTION_REQUEST_STATUS )
                .addQueryParam( "fuzeId", request.getFuzeId() ).buildUrl() );
        return makeRequest( request, Neo4jWriterTxRequestStatusResponse.class, HttpMethod.GET );
    }

    @Override
    public Neo4jWriterViewQuarantineResponse viewQuarantine( final Neo4jWriterViewQuarantineRequest request )
    {
        request.setEndpoint( getEndpointBuilder().create( request ).withServiceEndpoint( Endpoints.VIEW_QUARANTINE ).buildUrl() );
        return makeRequest( request, Neo4jWriterViewQuarantineResponse.class, HttpMethod.GET );
    }

    @Override
    public Neo4jWriterClearQuarantineResponse clearQuarantine( final Neo4jWriterClearQuarantineRequest request )
    {
        request.setEndpoint( getEndpointBuilder().create( request ).withServiceEndpoint( Endpoints.CLEAR_QUARANTINE ).buildUrl() );
        return makeRequest( request, Neo4jWriterClearQuarantineResponse.class, HttpMethod.DELETE );
    }

    /////////////////
    // Distributor //
    /////////////////

    @Override
    public DistributorSavePolicyResponse saveDistributionPolicy( final SavePolicyRequest request )
    {
        request.setEndpoint( getEndpointBuilder().create( request ).addPathVariable( request.getClusterName() )
                .addPathVariable( Endpoints.SAVE_DISTRIBUTION_POLICY ).addPathVariable( request.getPolicyName() ).buildUrl() );
        request.setBody( request.getPolicy() );
        return makeRequest( request, DistributorSavePolicyResponse.class, HttpMethod.POST );
    }

    @Override
    public DistributorLoadPolicyResponse loadDistributionPolicy( final LoadPolicyRequest request )
    {
        request.setEndpoint( getEndpointBuilder().create( request ).addPathVariable( request.getClusterName() )
                .addPathVariable( Endpoints.LOAD_DISTRIBUTION_POLICY ).addPathVariable( request.getPolicyName() ).buildUrl() );
        return makeRequest( request, DistributorLoadPolicyResponse.class, HttpMethod.GET );
    }

    @Override
    public DeletePolicyResponse deleteDistributionPolicy( final DeletePolicyRequest request )
    {
        request.setEndpoint( getEndpointBuilder().create( request ).addPathVariable( request.getClusterName() )
                .addPathVariable( Endpoints.DELETE_DISTRIBUTION_POLICY ).addPathVariable( request.getPolicyName() ).buildUrl() );
        return makeRequest( request, DeletePolicyResponse.class, HttpMethod.DELETE );
    }

    @Override
    public ActivatePolicyResponse activateDistributionPolicy( final ActivatePolicyRequest request )
    {
        request.setEndpoint( getEndpointBuilder().create( request ).addPathVariable( request.getClusterName() )
                .addPathVariable( Endpoints.ACTIVATE_DISTRIBUTION_POLICY ).addPathVariable( request.getPolicyName() ).buildUrl() );
        return makeRequest( request, ActivatePolicyResponse.class, HttpMethod.POST );
    }

    @Override
    public DeactivatePolicyResponse deactivateDistributionPolicy( final DeactivatePolicyRequest request )
    {
        request.setEndpoint( getEndpointBuilder().create( request ).addPathVariable( request.getClusterName() )
                .addPathVariable( Endpoints.DEACTIVATE_DISTRIBUTION_POLICY ).addPathVariable( request.getPolicyName() ).buildUrl() );
        return makeRequest( request, DeactivatePolicyResponse.class, HttpMethod.POST );
    }

    @Override
    public DistributorPolicyStatusResponse policyStatus( final DistributorPolicyStatusRequest request )
    {
        request.setEndpoint( getEndpointBuilder().create( request ).addPathVariable( request.getClusterName() )
                .addPathVariable( Endpoints.POLICY_STATUS ).addPathVariable( request.getPolicyName() ).buildUrl() );
        return makeRequest( request, DistributorPolicyStatusResponse.class, HttpMethod.GET );
    }

    @Override
    public DistributorActivePoliciesResponse activeDistributionPolicies( final DistributorActivePoliciesRequest request )
    {
        request.setEndpoint( getEndpointBuilder().create( request ).addPathVariable( request.getClusterName() )
                .addPathVariable( Endpoints.ACTIVE_DISTRIBUTION_POLICIES ).buildUrl() );
        return makeRequest( request, DistributorActivePoliciesResponse.class, HttpMethod.GET );
    }

    /////////////////
    // Fuze Worker //
    /////////////////

    @Override
    public WorkerSavePolicyResponse saveWorkerPolicy( final SavePolicyRequest request )
    {
        request.setEndpoint( getEndpointBuilder().create( request ).addPathVariable( request.getClusterName() ).addPathVariable(
                Endpoints.SAVE_WORKER_POLICY ).addPathVariable( request.getPolicyName() ).buildUrl() );
        request.setBody( request.getPolicy() );
        return makeRequest( request, WorkerSavePolicyResponse.class, HttpMethod.POST );
    }

    @Override
    public WorkerLoadPolicyResponse loadWorkerPolicy( final LoadPolicyRequest request )
    {
        request.setEndpoint( getEndpointBuilder().create( request ).addPathVariable( request.getClusterName() ).addPathVariable(
                Endpoints.LOAD_WORKER_POLICY ).addPathVariable( request.getPolicyName() ).buildUrl() );
        return makeRequest( request, WorkerLoadPolicyResponse.class, HttpMethod.GET );
    }

    @Override
    public DeletePolicyResponse deleteWorkerPolicy( final DeletePolicyRequest request )
    {
        request.setEndpoint( getEndpointBuilder().create( request ).addPathVariable( request.getClusterName() ).addPathVariable(
                Endpoints.DELETE_WORKER_POLICY ).addPathVariable( request.getPolicyName() ).buildUrl() );
        return makeRequest( request, DeletePolicyResponse.class, HttpMethod.DELETE );
    }

    @Override
    public ActivatePolicyResponse activateWorkerPolicy( final ActivatePolicyRequest request )
    {
        request.setEndpoint( getEndpointBuilder().create( request ).addPathVariable( request.getClusterName() ).addPathVariable(
                Endpoints.ACTIVATE_WORKER_POLICY ).addPathVariable( request.getPolicyName() ).buildUrl() );
        return makeRequest( request, ActivatePolicyResponse.class, HttpMethod.POST );
    }

    @Override
    public DeactivatePolicyResponse deactivateWorkerPolicy( final DeactivatePolicyRequest request )
    {
        request.setEndpoint( getEndpointBuilder().create( request ).addPathVariable( request.getClusterName() ).addPathVariable(
                Endpoints.DEACTIVATE_WORKER_POLICY ).addPathVariable( request.getPolicyName() ).buildUrl() );
        return makeRequest( request, DeactivatePolicyResponse.class, HttpMethod.POST );
    }

    //////////////////
    // Orchestrator //
    //////////////////

    @Override
    public OrchestratorSavePolicyResponse saveOrchestrationPolicy( final SavePolicyRequest request )
    {
        request.setEndpoint( getEndpointBuilder().create( request ).addPathVariable( request.getClusterName() ).addPathVariable(
                Endpoints.SAVE_ORCHESTRATION_POLICY ).addPathVariable( request.getPolicyName() ).buildUrl() );
        request.setBody( request.getPolicy() );
        return makeRequest( request, OrchestratorSavePolicyResponse.class, HttpMethod.POST );
    }

    @Override
    public OrchestratorLoadPolicyResponse loadOrchestrationPolicy( final LoadPolicyRequest request )
    {
        request.setEndpoint( getEndpointBuilder().create( request ).addPathVariable( request.getClusterName() ).addPathVariable(
                Endpoints.LOAD_ORCHESTRATION_POLICY ).addPathVariable( request.getPolicyName() ).buildUrl() );
        return makeRequest( request, OrchestratorLoadPolicyResponse.class, HttpMethod.GET );
    }

    @Override
    public DeletePolicyResponse deleteOrchestrationPolicy( final DeletePolicyRequest request )
    {
        request.setEndpoint( getEndpointBuilder().create( request ).addPathVariable( request.getClusterName() ).addPathVariable(
                Endpoints.DELETE_ORCHESTRATION_POLICY ).addPathVariable( request.getPolicyName() ).buildUrl() );
        return makeRequest( request, DeletePolicyResponse.class, HttpMethod.DELETE );
    }

    @Override
    public ActivatePolicyResponse activateOrchestrationPolicy( final ActivatePolicyRequest request )
    {
        request.setEndpoint( getEndpointBuilder().create( request ).addPathVariable( request.getClusterName() ).addPathVariable(
                Endpoints.ACTIVATE_ORCHESTRATION_POLICY ).addPathVariable( request.getPolicyName() ).buildUrl() );
        return makeRequest( request, ActivatePolicyResponse.class, HttpMethod.POST );
    }

    @Override
    public DeactivatePolicyResponse deactivateOrchestrationPolicy( final DeactivatePolicyRequest request )
    {
        request.setEndpoint( getEndpointBuilder().create( request ).addPathVariable( request.getClusterName() ).addPathVariable(
                Endpoints.DEACTIVATE_ORCHESTRATION_POLICY ).addPathVariable( request.getPolicyName() ).buildUrl() );
        return makeRequest( request, DeactivatePolicyResponse.class, HttpMethod.POST );
    }

    @Override
    protected <T extends GraphGridServiceResponse> T makeRequest( GraphGridServiceRequest request, Class responseType, HttpMethod httpMethod )
    {
        return super.makeRequest( request, responseType, httpMethod );
    }
}
