package com.graphgrid.sdk.model;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.graphgrid.sdk.core.model.GraphGridServiceRequest;

import static com.graphgrid.sdk.core.utils.Preconditions.checkNotEmpty;

@JsonAutoDetect
@JsonIgnoreProperties( ignoreUnknown = true )
public class DeleteFileRequest extends GraphGridServiceRequest
{

    private String orgGrn;

    private String fileGrn;

    private String region;

    public DeleteFileRequest()
    {
    }

    public DeleteFileRequest( String orgGrn, String fileGrn )
    {
        this.orgGrn = checkNotEmpty( orgGrn, "orgGrn" );
        this.fileGrn = checkNotEmpty( fileGrn, "fileGrn" );
    }

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

    public String getRegion()
    {
        return region;
    }

    public void setRegion( String region )
    {
        this.region = region;
    }
}
