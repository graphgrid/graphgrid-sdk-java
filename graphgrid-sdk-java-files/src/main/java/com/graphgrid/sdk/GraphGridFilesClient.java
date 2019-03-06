package com.graphgrid.sdk;

import com.graphgrid.sdk.core.GraphGridSecurityClientBase;
import com.graphgrid.sdk.core.SessionFactory;
import com.graphgrid.sdk.core.model.GraphGridServiceRequest;
import com.graphgrid.sdk.core.model.GraphGridServiceResponse;
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

import static com.graphgrid.sdk.support.Endpoints.CREATE_ONLY;
import static com.graphgrid.sdk.support.Endpoints.DOWNLOAD;


public class GraphGridFilesClient extends GraphGridSecurityClientBase implements GraphGridFiles
{

    private static final Logger LOGGER = LoggerFactory.getLogger( GraphGridFilesClient.class );

    public static final String NULL_REQUEST_ERROR = "request";

    public GraphGridFilesClient( String serviceBaseUrl )
    {
        super( serviceBaseUrl );
    }

    public GraphGridFilesClient( String serviceBaseUrl, SecurityConfig securityConfig )
    {
        super( serviceBaseUrl, securityConfig );
    }

    public GraphGridFilesClient( String serviceBaseUrl, SecurityConfig securityConfig, SessionFactory sessionFactory )
    {
        super( serviceBaseUrl, securityConfig, sessionFactory );
    }

    @Override
    public PersistFileNodeOnlyResponse createFileNodeWithoutUploading( PersistFileNodeOnlyRequest request )
    {
        request.setEndpoint(
                getEndpointBuilder().create( request ).withServiceEndpoint( CREATE_ONLY ).addQueryParam( "orgGrn", request.getOrgGrn() ).buildUrl() );
        request.setBody( request.getUploadFileMetadata() );
        return makeRequest( request, PersistFileNodeOnlyResponse.class, HttpMethod.POST );
    }

    @Override
    public FileServiceStatusResponse status( FileServiceStatusRequest request )
    {
        request.setEndpoint( getEndpointBuilder().create( request ).withServiceEndpoint( Endpoints.STATUS ).buildUrl() );
        return makeRequest( request, FileServiceStatusResponse.class, HttpMethod.GET );
    }

    @Override
    public void deleteFile( DeleteFileRequest request )
    {
        request.setEndpoint( getEndpointBuilder().create( request ).withServiceEndpoint( Endpoints.DELETE ).buildUrl() );
        makeRequest( request, DeleteFileResponse.class, HttpMethod.DELETE );
    }

    @Override
    public FindFileResponse findFileByGrn( FindFileRequest request )
    {
        request.setEndpoint( getEndpointBuilder().create( request ).addPathVariable( request.getGrn() ).buildUrl() );
        return makeRequest( request, FindFileResponse.class, HttpMethod.GET );
    }

    //todo implement
    @Override
    public UploadFileResponse uploadFile( UploadFileRequest request )
    {
        request.setEndpoint( getEndpointBuilder().create( request ).buildUrl() );
        return makeRequest( request, UploadFileResponse.class, HttpMethod.GET );
    }

    @Override
    public DownloadFilesResponse downloadFile( DownloadFilesRequest request )
    {
        request.setEndpoint( getEndpointBuilder().create( request ).withServiceEndpoint( DOWNLOAD ).addQueryParam( "grns", request.getGrns() )
                .addQueryParam( "duration", request.getDuration().toString() ).buildUrl() );
        return getClient().invoke( request, DownloadFilesResponse.class, HttpMethod.POST );
    }

    @Override
    public CreateRelationshipResponse createRelationship( CreateRelationshipRequest request )
    {
        request.setEndpoint( getEndpointBuilder().create( request ) //
                .withServiceEndpoint( Endpoints.CREATE_RELATIONSHIP ) //
                .addQueryParam( "fileGrn", request.getFileGrn() ).addQueryParam( "resourceGrn", request.getResourceGrn() )
                .addQueryParam( "relationshipType", request.getRelationshipType() )
                .addQueryParam( "relationshipDirection", request.getRelationshipDirection(), false ).buildUrl() );
        return makeRequest( request, CreateRelationshipResponse.class, HttpMethod.PUT );
    }

    @Override
    public FindFileResponse findByResource( FindByResourceRequest request )
    {
        request.setEndpoint( getEndpointBuilder().create( request ).withServiceEndpoint( Endpoints.FIND_BY_RESOURCE )
                .addQueryParam( "resourceGrn", request.getResourceGrn() ).addQueryParam( "relationshipType", request.getRelationshipType(), false )
                .buildUrl() );
        return makeRequest( request, FindFileResponse.class, HttpMethod.GET );
    }

    @Override
    protected <T extends GraphGridServiceResponse> T makeRequest( GraphGridServiceRequest request, Class responseType, HttpMethod httpMethod )
    {
        return super.makeRequest( request, responseType, httpMethod );
    }
}
