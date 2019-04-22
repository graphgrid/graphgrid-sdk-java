package com.graphgrid.sdk.ml.model.transformation;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import javax.validation.constraints.NotEmpty;

@JsonAutoDetect
@Getter
@Setter
@EqualsAndHashCode
public class DataDestination
{
    @NotEmpty
    private List<String> nodeLabels;
    @NotEmpty
    private Set<String> sourceGRNs;
}
