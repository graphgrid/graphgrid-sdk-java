package com.graphgrid.sdk.model;

import com.graphgrid.sdk.core.model.GraphGridServiceRequest;

import java.util.List;

public class UploadFileRequest extends GraphGridServiceRequest
{


    private String bucket;
    private String key;
    private List<String> metadata;
    // todo MultipartFile is a spring class find solution without using spring
//    private List<MultipartFile> fileData;
    private String orgGrn;

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
