package com.graphgrid.sdk.ml.model.transformation;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.graphgrid.sdk.ml.constant.PolicyType;
import com.graphgrid.sdk.ml.model.MLPolicy;

@JsonAutoDetect
@JsonDeserialize( as = TransformationPolicy.class )
@JsonTypeName( PolicyType.TRANSFORMATION_POLICY )
@JsonInclude( JsonInclude.Include.NON_NULL )
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class TransformationPolicy extends MLPolicy
{

    @Valid
    private TransformationOption option = new TransformationOption();
    @Valid
    @NotNull
    private DataSource source;
    @Valid
    private Assignment[] assignments;
    @Valid
    @NotEmpty
    private Map<String,Feature> feature;
    @Valid
    @NotNull
    private DataDestination destination;
    @JsonIgnore
    private boolean inner;
    @JsonIgnore
    private String task;
}
