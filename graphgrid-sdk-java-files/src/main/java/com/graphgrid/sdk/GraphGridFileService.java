package com.graphgrid.sdk;

import com.graphgrid.sdk.model.DeleteFileRequest;
import com.graphgrid.sdk.model.FileServiceStatusRequest;
import com.graphgrid.sdk.model.FileServiceStatusResponse;
import com.graphgrid.sdk.model.FindFileRequest;
import com.graphgrid.sdk.model.FindFileResponse;
import com.graphgrid.sdk.model.PersistFileNodeOnlyRequest;
import com.graphgrid.sdk.model.PersistFileNodeOnlyResponse;
import com.graphgrid.sdk.model.UploadFileRequest;
import com.graphgrid.sdk.model.UploadFileResponse;

public interface GraphGridFileService
{

    PersistFileNodeOnlyResponse createFileNodeWithoutUploading( PersistFileNodeOnlyRequest request );

    FileServiceStatusResponse status( FileServiceStatusRequest request );

    void deleteFile( DeleteFileRequest request );

    FindFileResponse findFileByGrn( FindFileRequest request);

    UploadFileResponse uploadFile( UploadFileRequest request );

}
