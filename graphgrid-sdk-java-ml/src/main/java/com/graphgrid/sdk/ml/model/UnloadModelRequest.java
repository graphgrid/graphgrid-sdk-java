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
public class UnloadModelRequest extends GraphGridServiceRequest
{

    private String clusterName;

    public UnloadModelRequest( String clusterName )
    {
        this.clusterName = clusterName;
    }
}
