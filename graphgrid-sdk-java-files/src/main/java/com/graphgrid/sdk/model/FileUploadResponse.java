package com.graphgrid.sdk.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.graphgrid.sdk.core.model.GraphGridServiceResponse;

import java.util.List;

@JsonAutoDetect
@JsonIgnoreProperties( ignoreUnknown = true )
public class FileUploadResponse extends GraphGridServiceResponse
{

    @JsonUnwrapped
    private List<FileNode> files;


    public List<FileNode> getFiles()
    {
        return files;
    }

    public void setFiles( List<FileNode> files )
    {
        this.files = files;
    }
}
