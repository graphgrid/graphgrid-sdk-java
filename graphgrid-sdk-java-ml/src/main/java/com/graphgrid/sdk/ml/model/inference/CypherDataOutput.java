package com.graphgrid.sdk.ml.model.inference;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
import javax.validation.constraints.NotBlank;

@JsonAutoDetect
@JsonInclude( JsonInclude.Include.NON_NULL )
@NoArgsConstructor
@Getter
@Setter
public class CypherDataOutput
{

    @NotBlank
    private String cypher;
    private Map<String,Object> parameters;
}
