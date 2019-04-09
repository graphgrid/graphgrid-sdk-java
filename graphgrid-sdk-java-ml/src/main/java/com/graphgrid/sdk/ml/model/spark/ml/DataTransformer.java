package com.graphgrid.sdk.ml.model.spark.ml;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import javax.validation.constraints.NotBlank;

/**
 * Transform a Dataset to another Dataset.
 */
@JsonAutoDetect
@JsonInclude( JsonInclude.Include.NON_NULL )
@Getter
@Setter
@EqualsAndHashCode
public class DataTransformer
{
    @NotBlank
    private String name;
    @NotBlank
    private String dataFrame;
    private Map<String,String> outputs;

    public DataTransformer()
    {
        outputs = new HashMap<>();
    }
}
