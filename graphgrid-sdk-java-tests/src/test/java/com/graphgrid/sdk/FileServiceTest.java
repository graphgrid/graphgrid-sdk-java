package com.graphgrid.sdk;

import com.graphgrid.sdk.core.exception.GraphGridSdkException;
import com.graphgrid.sdk.core.security.ClientCredentialsTokenRequest;
import com.graphgrid.sdk.core.security.GraphGridSecurityClient;
import com.graphgrid.sdk.core.security.NoTokenRequest;
import com.graphgrid.sdk.core.security.SecurityService;
import com.graphgrid.sdk.core.security.TokenRequest;
import com.graphgrid.sdk.core.security.UserTokenRequest;
import com.graphgrid.sdk.model.FileNode;
import com.graphgrid.sdk.model.FileServiceStatusRequest;
import com.graphgrid.sdk.model.FileServiceStatusResponse;
import com.graphgrid.sdk.model.FindFileRequest;
import com.graphgrid.sdk.model.FindFileResponse;
import com.graphgrid.sdk.model.PersistFileNodeOnlyRequest;
import com.graphgrid.sdk.model.PersistFileNodeOnlyResponse;
import com.graphgrid.sdk.model.UploadFileMetadata;
import org.assertj.core.util.Lists;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class FileServiceTest extends TestBase
{

    @Test
    public void testStatus() throws Exception
    {
        final GraphGridFilesClient client = new GraphGridFilesClient( "https://dev-api.graphgrid.com/1.0/file", securityConfig );
        final FileServiceStatusResponse response = client.status( new FileServiceStatusRequest().withAuthMethod( new ClientCredentialsTokenRequest() ) );

        assertNotNull( response );
    }

    @Ignore( "calls service" )
    @Test
    public void uploadGetDeleteFileInternalServerError()
    {
        final UploadFileMetadata.CreateRelationship createRelationship = new UploadFileMetadata.CreateRelationship();
        createRelationship.setGrn( "grn:gg:neo4jarchive:Mm5FzYHWZd92Tx3rqKpGHaDc0pdjMmZclyKgK4fe8sas" );
        createRelationship.setDirection( "OUTGOING" );
        createRelationship.setType( "TEST_REL" );

        // Upload files
        final FileNode fileNode = new FileNode();
        fileNode.setBucket( "sample-bucket" );
        fileNode.setFilename( "sample-file" );
        fileNode.setKey( "sample-key" );
        fileNode.setDescription( "sample" );
        fileNode.setGrn( "grn:gg:file:Mm5FzYHWZd92Tx3rqKpGHaDc0pdjMmZclyKgK4fe8sUL" );

        final UploadFileMetadata uploadFileMetadata = new UploadFileMetadata();
        uploadFileMetadata.withCreateProperties( new UploadFileMetadata.CreateProperties().withMd5( "auto" ).withSha1( "auto" ).withSha256( "auto" ) )
                .withFileNode( fileNode ).withCreateRelationships( Lists.newArrayList( createRelationship ) );
        uploadFileMetadata.setFileNode( fileNode );

        final PersistFileNodeOnlyRequest request = new PersistFileNodeOnlyRequest();
        request.setOrgGrn( "grn:gg:org:Mm5FzYHWZd92Tx3rqKpGHaDc0pdjMmZclyKgK4fe8sUL" );
        request.setUploadFileMetadata( uploadFileMetadata );

        final HashMap<String,String> map = new HashMap<>();
        map.put( "Authorization", "Bearer a2ce4bdf-7559-4d3c-8249-bed353041b8b" );
        request.withHeaders( map );


        final GraphGridFilesClient client = new GraphGridFilesClient( "https://dev-api.graphgrid.com/1.0/file" );
        final PersistFileNodeOnlyResponse response = client.createFileNodeWithoutUploading( request );
    }

    @Test
    public void urlNotFound() throws IOException
    {
        GraphGridSdkException exception = null;
        final GraphGridFilesClient client = new GraphGridFilesClient( "https://dev-api.graphgrid.com/1.0/fileNotThere" );
        try
        {
            client.status( new FileServiceStatusRequest().withAuthMethod( new NoTokenRequest() ) );
        }
        catch ( GraphGridSdkException ex )
        {
            exception = ex;
        }
        assertNotNull( exception );
        assertEquals( 404, exception.getHttpStatusCode() );
    }

    @Test
    public void notAuthorized() throws IOException
    {
        final FileNode fileNode = new FileNode();
        final UploadFileMetadata uploadFileMetadata = new UploadFileMetadata();
        uploadFileMetadata.setFileNode( fileNode );

        final PersistFileNodeOnlyRequest request = new PersistFileNodeOnlyRequest( );
        request.setOrgGrn( "grn" );
        request.setUploadFileMetadata( uploadFileMetadata );
        request.setRequestAuthMethod( new NoTokenRequest() );

        final HashMap<String,String> map = new HashMap<>();
        request.withHeaders( map );


        final GraphGridFilesClient client = new GraphGridFilesClient( "https://dev-api.graphgrid.com/1.0/file" );

        GraphGridSdkException exception = null;
        try
        {
            client.createFileNodeWithoutUploading( request );
        }
        catch ( GraphGridSdkException ex )
        {
            exception = ex;
        }
        assertNotNull( exception );
        assertEquals( exception.getHttpStatusCode(), 401 );
    }

    @Test( expected = com.graphgrid.sdk.core.exception.GraphGridSdkException.class )
    public void invalidToken()
    {
        String fileGrn = "grn:gg:file:Mm5FzYHWZd92Tx3rqKpGHaDc0pdjMmZclyKgK4fe8sUL";

        final GraphGridFilesClient client = new GraphGridFilesClient( "https://dev-api.graphgrid.com/1.0/file" );

        final FindFileRequest request = new FindFileRequest( fileGrn ).withAuthMethod( new TokenRequest( "ddf08ff3-ee0c-4b02-86e7-1fa551a2faa7" ) );
        request.setGrn( fileGrn );

        final FindFileResponse file = client.findFileByGrn( request );
        assertNotNull( file );
        assertNotNull( file.getFileNode() );
    }

    @Test
    public void getFileNodeWithPreexistingToken()
    {
        String fileGrn = "grn:gg:file:Mm5FzYHWZd92Tx3rqKpGHaDc0pdjMmZclyKgK4fe8sUL";


        SecurityService securityService = new GraphGridSecurityClient( securityConfig );
        String token = securityService.getTokenForSecurityCredentials().getAccessToken();

        final GraphGridFilesClient client = new GraphGridFilesClient( "https://dev-api.graphgrid.com/1.0/file" );


        final FindFileRequest request = new FindFileRequest( fileGrn ).withAuthMethod( new TokenRequest( token ) );
        request.setGrn( fileGrn );

        final FindFileResponse file = client.findFileByGrn( request );
        assertNotNull( file );
        assertNotNull( file.getFileNode() );
    }

    @Ignore("")
    @Test
    public void getFileNodeWithUserToken() throws Exception
    {
        String fileGrn = "grn:gg:file:Mm5FzYHWZd92Tx3rqKpGHaDc0pdjMmZclyKgK4fe8sUL";

        final GraphGridFilesClient client = new GraphGridFilesClient( "https://dev-api.graphgrid.com/1.0/file", securityConfig );


        final FindFileRequest request = new FindFileRequest( fileGrn ).withAuthMethod( new UserTokenRequest( username, password ) );
        request.setGrn( fileGrn );

        final FindFileResponse file = client.findFileByGrn( request );
        assertNotNull( file );
        assertNotNull( file.getFileNode() );
    }

    @Test
    public void getFileNodeWithUserClientToken() throws Exception
    {
        String fileGrn = "grn:gg:file:Mm5FzYHWZd92Tx3rqKpGHaDc0pdjMmZclyKgK4fe8sUL";

        final GraphGridFilesClient client = new GraphGridFilesClient( "https://dev-api.graphgrid.com/1.0/file", securityConfig );

        // somewhere else
        final FindFileRequest request = new FindFileRequest( fileGrn );

        final FindFileResponse file = client.findFileByGrn( request );
        assertNotNull( file );
        assertNotNull( file.getFileNode() );
    }
}
