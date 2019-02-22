package com.graphgrid.sdk;

import com.graphgrid.files.model.DeleteFileRequest;
import com.graphgrid.files.model.FileServiceStatusRequest;
import com.graphgrid.files.model.FileServiceStatusResponse;
import com.graphgrid.files.model.PersistFileNodeOnlyRequest;
import com.graphgrid.files.model.PersistFileNodeOnlyResponse;

public interface GraphGridFileService
{


    PersistFileNodeOnlyResponse createFileNodeWithoutUploading( PersistFileNodeOnlyRequest request );

    FileServiceStatusResponse status( FileServiceStatusRequest request );

    void deleteFile( DeleteFileRequest request );

}
