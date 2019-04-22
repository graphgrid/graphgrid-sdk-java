package com.graphgrid.sdk.ml.model.training;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.graphgrid.sdk.ml.model.dataframe.ColumnSchema;

@JsonAutoDetect
@JsonInclude( JsonInclude.Include.NON_NULL )
@Getter
@Setter
@EqualsAndHashCode
public class DataFrameSource
{
    @NotBlank
    private String name;
    @Valid
    private InnerTransformation transformation;
    @NotBlank
    private String cypher;
    private Map<String,Object> parameters;
    @Valid
    @NotEmpty
    private List<ColumnSchema> schema;
}
