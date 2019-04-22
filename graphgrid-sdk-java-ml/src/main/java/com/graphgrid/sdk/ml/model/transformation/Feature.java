package com.graphgrid.sdk.ml.model.transformation;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@JsonAutoDetect
@JsonInclude( JsonInclude.Include.NON_EMPTY )
@Getter
@Setter
@EqualsAndHashCode
public class Feature
{
    @NotBlank
    private String source;
    private String description;
}
