package com.graphgrid.sdk.ml.model.inference;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.graphgrid.sdk.ml.constant.PolicyType;
import com.graphgrid.sdk.ml.model.MLPolicy;
import com.graphgrid.sdk.ml.model.dataframe.DataSchema;

@JsonAutoDetect
@JsonDeserialize( as = BatchInferencePolicy.class )
@JsonTypeName( PolicyType.BATCH_INFERENCE_POLICY )
@NoArgsConstructor
@Getter
@Setter
public class BatchInferencePolicy extends MLPolicy
{

    private String jobId;
    @NotBlank
    private String task;
    @NotBlank
    private String policyName;
    @Valid
    @NotNull
    private DataSchema schema;
    @Valid
    @NotNull
    private CypherDataInput inputQuery;
    @Valid
    @NotNull
    private CypherDataOutput outputQuery;

    @Override
    public boolean equals( Object o )
    {
        if ( this == o )
        {
            return true;
        }

        if ( o == null || getClass() != o.getClass() )
        {
            return false;
        }

        BatchInferencePolicy that = (BatchInferencePolicy) o;

        return new EqualsBuilder().appendSuper( super.equals( o ) ).append( jobId, that.jobId ).append( task, that.task ).append( policyName,
                that.policyName ).append( schema, that.schema ).append( inputQuery, that.inputQuery ).append( outputQuery, that.outputQuery ).isEquals();
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder( 17, 37 ).appendSuper( super.hashCode() ).append( jobId ).append( task ).append( policyName ).append( schema ).append(
                inputQuery ).append( outputQuery ).toHashCode();
    }
}
