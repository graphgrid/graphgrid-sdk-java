package com.graphgrid.sdk.ml.model.transformation;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.NotBlank;

@JsonAutoDetect
@Getter
@Setter
@EqualsAndHashCode
public class Assignment
{
    private Set<String> inputs = new HashSet<>();
    @NotBlank
    private String assignment;
    @NotBlank
    private String output;
}
