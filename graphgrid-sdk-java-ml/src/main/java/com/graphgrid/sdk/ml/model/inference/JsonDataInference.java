package com.graphgrid.sdk.ml.model.inference;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.graphgrid.sdk.ml.model.dataframe.DataSchema;

@JsonAutoDetect
@NoArgsConstructor
@Getter
@Setter
public class JsonDataInference
{

    @Valid
    @NotNull
    private DataSchema schema;
    @NotEmpty
    private List<Object> data;
}
