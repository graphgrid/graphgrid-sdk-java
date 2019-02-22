package com.graphgrid.sdk.model;


import com.graphgrid.sdk.core.model.GraphGridServiceRequest;

public class PersistFileNodeOnlyRequest extends GraphGridServiceRequest
{

    private UploadFileMetadata uploadFileMetadata;

    private String orgGrn;


    public UploadFileMetadata getUploadFileMetadata()
    {
        return uploadFileMetadata;
    }

    public void setUploadFileMetadata( UploadFileMetadata uploadFileMetadata )
    {
        this.uploadFileMetadata = uploadFileMetadata;
    }

    public String getOrgGrn()
    {
        return orgGrn;
    }

    public void setOrgGrn( String orgGrn )
    {
        this.orgGrn = orgGrn;
    }
}
