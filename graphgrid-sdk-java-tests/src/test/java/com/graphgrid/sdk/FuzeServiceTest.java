package com.graphgrid.sdk;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Collections;

import com.graphgrid.sdk.core.security.ClientCredentialsTokenRequest;
import com.graphgrid.sdk.model.BrokerEndpoint;
import com.graphgrid.sdk.model.FuzeServiceStatusRequest;
import com.graphgrid.sdk.model.FuzeServiceStatusResponse;
import com.graphgrid.sdk.model.Metadata;
import com.graphgrid.sdk.model.Neo4jCredentials;
import com.graphgrid.sdk.model.distributor.DistributionPolicy;
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

/**
 * @author bradnussbaum
 */
public class FuzeServiceTest extends TestBase
{

    @Test
    public void testStatus()
    {
        final GraphGridFuzeClient client = new GraphGridFuzeClient( "https://dev-api.graphgrid.com/1.0/fuze", securityConfig );
        final FuzeServiceStatusResponse status = client.status( new FuzeServiceStatusRequest().withAuthMethod( new ClientCredentialsTokenRequest() ) );

        Assert.assertNotNull( status );
    }

    @Ignore( "calls service" )
    @Test
    public void policyManagementEndpoints()
    {
        final GraphGridFuze graphGridFuze = new GraphGridFuzeClient( "https://dev-api.graphgrid.com/1.0/fuze", securityConfig );

        DistributionPolicy distributionPolicy = new DistributionPolicy();
        distributionPolicy.setListeningBrokerEndpoint( BrokerEndpoint.kafkaEndpoint( "com.graphgrid.topic.sdk-test" ) );
        distributionPolicy.setNeo4jCredentials( new Neo4jCredentials( "bolt://neo4j-db:7687", "neo4j", "admin" ) );
        distributionPolicy.setForwardingRules( Collections.singletonList( new DistributionPolicy.ForwardingRule( "WITH {txData} as txData RETURN txData AS result", new DistributionPolicy.ForwardingRule.Multicast( Collections.singletonList( BrokerEndpoint.kafkaEndpoint( "com.graphgrid.topic.skd-next" ) ) ), "result" ) ) );

        final String clusterName = "gg-test-neo";
        final String policyName = "gg-test-policy-distributor" + RandomStringUtils.randomAlphabetic( 5 );

        PolicySaveResponse policySaveResponse = graphGridFuze.savePolicy( new PolicySaveRequest( clusterName, policyName, distributionPolicy ) );
        PolicyRetrieveResponse policyRetrieveResponse = graphGridFuze.retrievePolicy( new PolicyRetrieveRequest( clusterName, policyName ) );
        PolicyActivateResponse policyActivateResponse = graphGridFuze.activatePolicy( new PolicyActivateRequest( clusterName, policyName ) );
        PolicyDeactivateResponse policyDeactivateResponse = graphGridFuze.deactivatePolicy( new PolicyDeactivateRequest( clusterName, policyName ) );
        PolicyDeleteResponse policyDeleteResponse = graphGridFuze.deletePolicy( new PolicyDeleteRequest( clusterName, policyName ) );
    }
}
