package com.graphgrid.sdk.ml.model.dataframe;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@JsonAutoDetect
@Getter
@Setter
public class DataSchema
{
    @Valid
    @NotEmpty
    private List<ColumnSchema> input;
    @Valid
    @NotEmpty
    private List<ColumnSchema> output;
}
