package com.graphgrid.files.model;

import com.graphgrid.core.model.GraphGridServiceRequest;

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
