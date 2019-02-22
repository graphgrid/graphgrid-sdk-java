package com.graphgrid.sdk;

import com.graphgrid.sdk.core.GraphGridHttpClient;
import com.graphgrid.sdk.core.GraphGridSecurityAwareServiceBase;
import com.graphgrid.sdk.core.security.SecurityConfig;
import com.graphgrid.sdk.core.utils.HttpMethod;
import com.graphgrid.sdk.model.DeleteFileRequest;
import com.graphgrid.sdk.model.DeleteFileResponse;
import com.graphgrid.sdk.model.FileServiceStatusRequest;
import com.graphgrid.sdk.model.FileServiceStatusResponse;
import com.graphgrid.sdk.model.FindFileRequest;
import com.graphgrid.sdk.model.FindFileResponse;
import com.graphgrid.sdk.model.PersistFileNodeOnlyRequest;
import com.graphgrid.sdk.model.PersistFileNodeOnlyResponse;
import com.graphgrid.sdk.model.UploadFileRequest;
import com.graphgrid.sdk.model.UploadFileResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.graphgrid.sdk.core.utils.Preconditions.checkNotNull;

public class GraphGridFileServiceClient extends GraphGridSecurityAwareServiceBase implements GraphGridFileService
{

    private static final Logger LOGGER = LoggerFactory.getLogger( GraphGridFileServiceClient.class );

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
        checkNotNull( request, "request" );

        request.setEndpoint(
                getEndpointBuilder().create( request ).withServiceEndpoint( "upload/createOnly" ).addQueryParam( "orgGrn", request.getOrgGrn() ).buildUrl() );
        request.setBody( request.getUploadFileMetadata() );
        request = getTokenRequestBuilder().authenticate( request );
        return this.getClient().invoke( request, PersistFileNodeOnlyResponse.class, HttpMethod.POST );
    }

    @Override
    public FileServiceStatusResponse status( FileServiceStatusRequest request )
    {
        checkNotNull( request, "request" );

        request.setEndpoint( getEndpointBuilder().create( request ).withServiceEndpoint( "status" ).buildUrl() );
        return this.getClient().invoke( request, FileServiceStatusResponse.class, HttpMethod.GET );
    }

    @Override
    public void deleteFile( DeleteFileRequest request )
    {
        checkNotNull( request, "request" );

        request.setEndpoint( getEndpointBuilder().create( request ).withServiceEndpoint( "delete" ).buildUrl() );
        request = getTokenRequestBuilder().authenticate( request );
        this.getClient().invoke( request, DeleteFileResponse.class, HttpMethod.DELETE );
    }

    @Override
    public FindFileResponse findFileByGrn( FindFileRequest request )
    {
        checkNotNull( request, "request" );

        request.setEndpoint( getEndpointBuilder().create( request ).addPathVariable( request.getGrn() ).buildUrl() );
        request = getTokenRequestBuilder().authenticate( request );
        return this.getClient().invoke( request, FindFileResponse.class, HttpMethod.GET );
    }

    //todo implement
    @Override
    public UploadFileResponse uploadFile( UploadFileRequest request )
    {
        checkNotNull( request, "request" );

        request.setEndpoint( getEndpointBuilder().create( request ).buildUrl() );
        request = getTokenRequestBuilder().authenticate( request );
        return this.getClient().invoke( request, UploadFileResponse.class, HttpMethod.GET );
    }
}
