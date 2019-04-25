package com.graphgrid.sdk.support;

public final class Endpoints
{
    public static final String STATUS = "status";

    // Neo4jWriter
    public static final String SAVE_NEO4J_WRITER_POLICY = "saveNeo4jWriterPolicy";
    public static final String LOAD_NEO4J_WRITER_POLICY = "loadNeo4jWriterPolicy";
    public static final String DELETE_NEO4J_WRITER_POLICY = "deleteNeo4jWriterPolicy";

    public static final String ACTIVATE_NEO4J_WRITER_POLICY = "activateNeo4jWriterPolicy";
    public static final String DEACTIVATE_NEO4J_WRITER_POLICY = "deactivateNeo4jWriterPolicy";

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
    public static final String SAVE_DISTRIBUTION_POLICY = "saveDistributionPolicy";
    public static final String LOAD_DISTRIBUTION_POLICY = "loadDistributionPolicy";
    public static final String DELETE_DISTRIBUTION_POLICY = "deleteDistributionPolicy";

    public static final String ACTIVATE_DISTRIBUTION_POLICY = "startBrokerForwarding";
    public static final String DEACTIVATE_DISTRIBUTION_POLICY = "stopBrokerForwarding";

    public static final String POLICY_STATUS = "forwardingStatus";
    public static final String ACTIVE_DISTRIBUTION_POLICIES = "activeBrokerDistributionPolicies";

    // Orchestrator
    public static final String SAVE_ORCHESTRATION_POLICY = "saveOrchestrationPolicy";
    public static final String LOAD_ORCHESTRATION_POLICY = "loadOrchestrationPolicy";
    public static final String DELETE_ORCHESTRATION_POLICY = "deleteOrchestrationPolicy";

    public static final String ACTIVATE_ORCHESTRATION_POLICY = "activateOrchestrationPolicy";
    public static final String DEACTIVATE_ORCHESTRATION_POLICY = "deactivateOrchestrationPolicy";

    private Endpoints()
    {
    }
}
