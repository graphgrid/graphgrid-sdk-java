package com.graphgrid.sdk.ml.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.graphgrid.sdk.core.model.GraphGridServiceRequest;

@JsonAutoDetect
@NoArgsConstructor
@Getter
@Setter
public class ShowFeatureRequest extends GraphGridServiceRequest
{

    private String clusterName;
    private String[] nodeLabels;
    private Integer limit;

    public ShowFeatureRequest( String clusterName, String[] nodeLabels, Integer limit )
    {
        this.clusterName = clusterName;
        this.nodeLabels = nodeLabels;
        this.limit = limit;
    }
}
