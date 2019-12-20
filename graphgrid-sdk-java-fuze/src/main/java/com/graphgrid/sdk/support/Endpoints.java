package com.graphgrid.sdk.support;

public final class Endpoints
{
    public static final String STATUS = "status";

    // Policy Management
    public static final String SAVE_POLICY = "savePolicy";
    public static final String RETRIEVE_POLICY = "retrievePolicy";
    public static final String DELETE_POLICY = "deletePolicy";
    public static final String ACTIVATE_POLICY = "activatePolicy";
    public static final String DEACTIVATE_POLICY = "deactivatePolicy";

    // Neo4jWriter
    public static final String ACTIVE_NEO4J_WRITER_POLICIES = "activeNeo4jWriterPolicies";

    public static final String WRITE = "write";
    public static final String WRITE_ASYNC = "writeAsync";
    public static final String READ = "read";
    public static final String READ_ASYNC = "readAsync";

    public static final String QUEUE_REQUEST_FOR_BATCHING = "queueRequestForBatching";
    public static final String BATCH_AND_EXECUTE_QUEUED_REQUESTS = "batchAndExecuteQueuedRequests";

    public static final String GET_TRANSACTION_RESULT = "getTransactionResult";
    public static final String GET_TRANSACTION_REQUEST = "getTransactionRequest";
    public static final String CHECK_TRANSACTION_REQUEST_STATUS = "checkTransactionRequestStatus";

    public static final String VIEW_QUARANTINE = "viewQuarantine";
    public static final String CLEAR_QUARANTINE = "clearQuarantine";

    // Distributor
    public static final String POLICY_STATUS = "forwardingStatus";
    public static final String ACTIVE_DISTRIBUTION_POLICIES = "activeBrokerDistributionPolicies";

    // Worker
    public static final String ACTIVE_WORKER_POLICIES = "activeWorkerPolicies";

    // Orchestrator
    public static final String ACTIVE_ORCHESTRATOR_POLICIES = "activeOrchestratorPolicies";

    private Endpoints()
    {
    }
}
