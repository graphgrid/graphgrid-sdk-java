package com.graphgrid.sdk.ml.model.inference;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.graphgrid.sdk.ml.model.dataframe.DataSchema;

@JsonAutoDetect
@Getter
@Setter
public class CypherDataInference
{

    @Valid
    @NotNull
    private DataSchema schema;
    @Valid
    @NotNull
    private CypherDataInput data;
}
