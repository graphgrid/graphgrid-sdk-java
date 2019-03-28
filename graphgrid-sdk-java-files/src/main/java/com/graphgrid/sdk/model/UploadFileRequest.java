package com.graphgrid.sdk.model;

import com.graphgrid.sdk.core.model.GraphGridServiceRequest;

import java.util.List;

public class UploadFileRequest extends GraphGridServiceRequest
{

    private String bucket;
    private String key;
    private List<String> metadata;
    // todo MultipartFile is a spring class find solution without using spring
    // MultipartFile
    private List<Object> fileData;
    private String orgGrn;
    private String region;

    private UploadFileMetadata uploadFileMetadata;

    public UploadFileMetadata getUploadFileMetadata()
    {
        return uploadFileMetadata;
    }

    public void setUploadFileMetadata( UploadFileMetadata uploadFileMetadata )
    {
        this.uploadFileMetadata = uploadFileMetadata;
    }


    public String getBucket()
    {
        return bucket;
    }

    public void setBucket( String bucket )
    {
        this.bucket = bucket;
    }

    public String getKey()
    {
        return key;
    }

    public void setKey( String key )
    {
        this.key = key;
    }

    public List<String> getMetadata()
    {
        return metadata;
    }

    public void setMetadata( List<String> metadata )
    {
        this.metadata = metadata;
    }

    public List<Object> getFileData()
    {
        return fileData;
    }

    public void setFileData( List<Object> fileData )
    {
        this.fileData = fileData;
    }

    public String getOrgGrn()
    {
        return orgGrn;
    }

    public void setOrgGrn( String orgGrn )
    {
        this.orgGrn = orgGrn;
    }

    public String getRegion()
    {
        return region;
    }

    public void setRegion( String region )
    {
        this.region = region;
    }
}
