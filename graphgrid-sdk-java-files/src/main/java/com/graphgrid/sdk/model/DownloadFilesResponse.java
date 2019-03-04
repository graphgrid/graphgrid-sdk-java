package com.graphgrid.sdk.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.graphgrid.sdk.core.exception.GraphGridSdkException;
import com.graphgrid.sdk.core.model.GraphGridServiceResponse;

import java.net.URL;
import java.util.Map;

@JsonAutoDetect
@JsonIgnoreProperties( ignoreUnknown = true )
public class DownloadFilesResponse extends GraphGridServiceResponse
{

    private Map<String,URL> downloadLinks;


    public Map<String,URL> getDownloadLinks()
    {
        return downloadLinks;
    }

    public void setDownloadLinks( Map<String,URL> downloadLinks )
    {
        this.downloadLinks = downloadLinks;
    }
}
