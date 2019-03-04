package com.graphgrid.sdk;

import com.graphgrid.sdk.core.GraphGridHttpClient;
import com.graphgrid.sdk.core.GraphGridSecurityAwareServiceBase;
import com.graphgrid.sdk.core.security.SecurityConfig;
import com.graphgrid.sdk.core.utils.HttpMethod;
import com.graphgrid.sdk.model.CreateRelationshipRequest;
import com.graphgrid.sdk.model.CreateRelationshipResponse;
import com.graphgrid.sdk.model.DeleteFileRequest;
import com.graphgrid.sdk.model.DeleteFileResponse;
import com.graphgrid.sdk.model.DownloadFilesRequest;
import com.graphgrid.sdk.model.DownloadFilesResponse;
import com.graphgrid.sdk.model.FileServiceStatusRequest;
import com.graphgrid.sdk.model.FileServiceStatusResponse;
import com.graphgrid.sdk.model.FindByResourceRequest;
import com.graphgrid.sdk.model.FindFileRequest;
import com.graphgrid.sdk.model.FindFileResponse;
import com.graphgrid.sdk.model.PersistFileNodeOnlyRequest;
import com.graphgrid.sdk.model.PersistFileNodeOnlyResponse;
import com.graphgrid.sdk.model.UploadFileRequest;
import com.graphgrid.sdk.model.UploadFileResponse;
import com.graphgrid.sdk.support.Endpoints;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.graphgrid.sdk.core.utils.Preconditions.checkNotNull;
import static com.graphgrid.sdk.support.Endpoints.CREATE_ONLY;
import static com.graphgrid.sdk.support.Endpoints.DOWNLOAD;

public class GraphGridFileServiceClient extends GraphGridSecurityAwareServiceBase implements GraphGridFileService
{

    private static final Logger LOGGER = LoggerFactory.getLogger( GraphGridFileServiceClient.class );

    public static final String NULL_REQUEST_ERROR = "request";

    public GraphGridFileServiceClient( String serviceBaseUrl )
    {
        super( serviceBaseUrl );
    }

    public GraphGridFileServiceClient( String serviceBaseUrl, SecurityConfig securityConfig )
    {
        super( serviceBaseUrl, securityConfig );
    }

    public GraphGridFileServiceClient( GraphGridHttpClient client, String serviceBaseUrl, SecurityConfig securityConfig )
    {
        super( client, serviceBaseUrl, securityConfig );
    }

    @Override
    public PersistFileNodeOnlyResponse createFileNodeWithoutUploading( PersistFileNodeOnlyRequest request )
    {
        checkNotNull( request, NULL_REQUEST_ERROR );

        request.setEndpoint(
                getEndpointBuilder().create( request ).withServiceEndpoint( CREATE_ONLY ).addQueryParam( "orgGrn", request.getOrgGrn() ).buildUrl() );
        request.setBody( request.getUploadFileMetadata() );
        request = getTokenRequestBuilder().authenticate( request );
        return this.getClient().invoke( request, PersistFileNodeOnlyResponse.class, HttpMethod.POST );
    }

    @Override
    public FileServiceStatusResponse status( FileServiceStatusRequest request )
    {
        checkNotNull( request, NULL_REQUEST_ERROR );

        request.setEndpoint( getEndpointBuilder().create( request ).withServiceEndpoint( Endpoints.STATUS ).buildUrl() );
        return this.getClient().invoke( request, FileServiceStatusResponse.class, HttpMethod.GET );
    }

    @Override
    public void deleteFile( DeleteFileRequest request )
    {
        checkNotNull( request, NULL_REQUEST_ERROR );
        ;

        request.setEndpoint( getEndpointBuilder().create( request ).withServiceEndpoint( Endpoints.DELETE ).buildUrl() );
        request = getTokenRequestBuilder().authenticate( request );
        this.getClient().invoke( request, DeleteFileResponse.class, HttpMethod.DELETE );
    }

    @Override
    public FindFileResponse findFileByGrn( FindFileRequest request )
    {
        checkNotNull( request, NULL_REQUEST_ERROR );
        ;

        request.setEndpoint( getEndpointBuilder().create( request ).addPathVariable( request.getGrn() ).buildUrl() );
        request = getTokenRequestBuilder().authenticate( request );
        return this.getClient().invoke( request, FindFileResponse.class, HttpMethod.GET );
    }

    //todo implement
    @Override
    public UploadFileResponse uploadFile( UploadFileRequest request )
    {
        checkNotNull( request, NULL_REQUEST_ERROR );
        ;

        request.setEndpoint( getEndpointBuilder().create( request ).buildUrl() );
        request = getTokenRequestBuilder().authenticate( request );
        return this.getClient().invoke( request, UploadFileResponse.class, HttpMethod.GET );
    }

    @Override
    public DownloadFilesResponse downloadFile( DownloadFilesRequest request )
    {
        checkNotNull( request, NULL_REQUEST_ERROR );

        request.setEndpoint( getEndpointBuilder().create( request ).withServiceEndpoint( DOWNLOAD ).addQueryParam( "grns", request.getGrns() )
                .addQueryParam( "duration", request.getDuration().toString() ).buildUrl() );
        request = getTokenRequestBuilder().authenticate( request );
        return getClient().invoke( request, DownloadFilesResponse.class, HttpMethod.POST );
    }

    @Override
    public CreateRelationshipResponse createRelationship( CreateRelationshipRequest request )
    {
        checkNotNull( request, NULL_REQUEST_ERROR );

        request.setEndpoint( getEndpointBuilder().create( request ) //
                .withServiceEndpoint( Endpoints.CREATE_RELATIONSHIP ) //
                .addQueryParam( "fileGrn", request.getFileGrn() ).addQueryParam( "resourceGrn", request.getResourceGrn() )
                .addQueryParam( "relationshipType", request.getRelationshipType() )
                .addQueryParam( "relationshipDirection", request.getRelationshipDirection(), false ).buildUrl() );
        request = getTokenRequestBuilder().authenticate( request );
        return getClient().invoke( request, CreateRelationshipResponse.class, HttpMethod.PUT );
    }

    @Override
    public FindFileResponse findByResource( FindByResourceRequest request )
    {
        checkNotNull( request, NULL_REQUEST_ERROR );
        request.setEndpoint( getEndpointBuilder().create( request ).withServiceEndpoint( Endpoints.FIND_BY_RESOURCE )
                .addQueryParam( "resourceGrn", request.getResourceGrn() ).addQueryParam( "relationshipType", request.getRelationshipType(), false )
                .buildUrl() );
        request = getTokenRequestBuilder().authenticate( request );
        return getClient().invoke( request, FindFileResponse.class, HttpMethod.GET );
    }
}
