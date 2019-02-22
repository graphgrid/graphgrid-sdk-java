package com.graphgrid.sdk.model;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.graphgrid.sdk.core.model.GraphGridServiceRequest;

@JsonAutoDetect
@JsonIgnoreProperties( ignoreUnknown = true )
public class DeleteFileRequest extends GraphGridServiceRequest
{

    private String orgGrn;

    private String fileGrn;

    public String getOrgGrn()
    {
        return orgGrn;
    }

    public void setOrgGrn( String orgGrn )
    {
        this.orgGrn = orgGrn;
    }

    public String getFileGrn()
    {
        return fileGrn;
    }

    public void setFileGrn( String fileGrn )
    {
        this.fileGrn = fileGrn;
    }
}
