package com.graphgrid.sdk.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.graphgrid.sdk.core.model.GraphGridServiceRequest;

import java.util.List;

@JsonAutoDetect
@JsonIgnoreProperties( ignoreUnknown = true )
public class DownloadFilesRequest extends GraphGridServiceRequest
{

    private List<String> grns;

    private Long duration;

    public List<String> getGrns()
    {
        return grns;
    }

    public void setGrns( List<String> grns )
    {
        this.grns = grns;
    }

    public Long getDuration()
    {
        return duration;
    }

    public void setDuration( Long duration )
    {
        this.duration = duration;
    }
}
