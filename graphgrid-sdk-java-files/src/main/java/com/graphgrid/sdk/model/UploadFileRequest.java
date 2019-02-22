package com.graphgrid.sdk.model;

import com.graphgrid.sdk.core.model.GraphGridServiceRequest;

public class UploadFileRequest extends GraphGridServiceRequest
{

    private UploadFileMetadata uploadFileMetadata;

    public UploadFileMetadata getUploadFileMetadata()
    {
        return uploadFileMetadata;
    }

    public void setUploadFileMetadata( UploadFileMetadata uploadFileMetadata )
    {
        this.uploadFileMetadata = uploadFileMetadata;
    }
}
