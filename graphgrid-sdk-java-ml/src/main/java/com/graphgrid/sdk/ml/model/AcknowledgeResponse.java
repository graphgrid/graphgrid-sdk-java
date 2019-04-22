package com.graphgrid.sdk.ml.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.graphgrid.sdk.core.model.GraphGridServiceResponse;

@NoArgsConstructor
@Getter
@Setter
public class AcknowledgeResponse extends GraphGridServiceResponse
{

    private boolean acknowledged;
    private String message;

    public AcknowledgeResponse( boolean acknowledged, String message )
    {
        this.acknowledged = acknowledged;
        this.message = message;
    }
}
