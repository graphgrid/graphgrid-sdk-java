package com.graphgrid.sdk.ml.model.inference;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.graphgrid.sdk.ml.model.training.InnerTransformation;

@JsonAutoDetect
@JsonInclude( JsonInclude.Include.NON_NULL )
@Getter
@Setter
public class CypherDataInput
{

    @Valid
    private InnerTransformation transformation;
    @NotBlank
    private String cypher;
    private Map<String,Object> parameters;
}
