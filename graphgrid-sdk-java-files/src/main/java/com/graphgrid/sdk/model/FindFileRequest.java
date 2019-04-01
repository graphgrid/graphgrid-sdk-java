package com.graphgrid.sdk.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.graphgrid.sdk.core.model.GraphGridServiceRequest;

import static com.graphgrid.sdk.core.utils.Preconditions.checkNotEmpty;

@JsonAutoDetect
@JsonIgnoreProperties( ignoreUnknown = true )
public class FindFileRequest extends GraphGridServiceRequest
{
    private String grn;

    public FindFileRequest()
    {
    }


    public FindFileRequest( String grn )
    {
        this.grn = checkNotEmpty( grn, "fileGrn" );
    }

    public String getGrn()
    {
        return grn;
    }

    public void setGrn( String grn )
    {
        this.grn = grn;
    }

}
