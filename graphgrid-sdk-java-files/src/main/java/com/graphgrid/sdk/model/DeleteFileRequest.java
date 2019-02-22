package com.graphgrid.sdk.model;


import com.graphgrid.sdk.core.model.GraphGridServiceRequest;

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
