package com.graphgrid.sdk;

import com.graphgrid.sdk.model.CreateRelationshipRequest;
import com.graphgrid.sdk.model.CreateRelationshipResponse;
import com.graphgrid.sdk.model.DeleteFileRequest;
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

public interface GraphGridFiles
{

    PersistFileNodeOnlyResponse createFileNodeWithoutUploading( PersistFileNodeOnlyRequest request );

    FileServiceStatusResponse status( FileServiceStatusRequest request );

    void deleteFile( DeleteFileRequest request );

    FindFileResponse findFileByGrn( FindFileRequest request);

    UploadFileResponse uploadFile( UploadFileRequest request );

    DownloadFilesResponse downloadFile( DownloadFilesRequest request);

    CreateRelationshipResponse createRelationship( CreateRelationshipRequest request);

    FindFileResponse findByResource( FindByResourceRequest request);

}
