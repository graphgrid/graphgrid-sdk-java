package com.graphgrid.sdk.ml.model.spark.ml;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@JsonAutoDetect
@JsonInclude( JsonInclude.Include.NON_NULL )
@Getter
@Setter
@EqualsAndHashCode
public class Evaluator
{

    @NotBlank
    protected String type;
    protected Map<String,Object> parameters;
    @NotEmpty
    protected Set<String> metrics;

    public Evaluator()
    {
        parameters = new HashMap<>();
        metrics = new HashSet<>();
    }
}
