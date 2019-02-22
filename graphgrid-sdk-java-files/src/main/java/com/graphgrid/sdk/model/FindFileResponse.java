package com.graphgrid.sdk.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.graphgrid.sdk.core.model.GraphGridServiceResponse;

@JsonAutoDetect
@JsonIgnoreProperties( ignoreUnknown = true )
public class FindFileResponse extends GraphGridServiceResponse
{

    @JsonUnwrapped
    private FileNode fileNode;

    public FindFileResponse()
    {
    }

    public FindFileResponse( FileNode fileNode )
    {
        this.fileNode = fileNode;
    }

    public FileNode getFileNode()
    {
        return fileNode;
    }

    public void setFileNode( FileNode fileNode )
    {
        this.fileNode = fileNode;
    }
}
