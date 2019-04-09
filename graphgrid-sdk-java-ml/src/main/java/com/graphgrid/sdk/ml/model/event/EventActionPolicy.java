package com.graphgrid.sdk.ml.model.event;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

import com.graphgrid.sdk.ml.model.MLPolicy;

@JsonAutoDetect
@Getter
@Setter
public class EventActionPolicy
{

    private String cypherCondition;
    private String brokerType;
    private String actionType;
    private MLPolicy policy;
}
