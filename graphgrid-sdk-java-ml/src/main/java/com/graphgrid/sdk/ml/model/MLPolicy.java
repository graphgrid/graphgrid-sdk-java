package com.graphgrid.sdk.ml.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.graphgrid.sdk.ml.constant.PolicyType;
import com.graphgrid.sdk.ml.model.event.EventActionPolicy;
import com.graphgrid.sdk.ml.model.inference.BatchInferencePolicy;
import com.graphgrid.sdk.ml.model.training.TrainingPolicy;
import com.graphgrid.sdk.ml.model.transformation.TransformationPolicy;
import com.graphgrid.sdk.ml.utils.PolicyDeserializer;

@JsonAutoDetect
@JsonSubTypes({
        @JsonSubTypes.Type( value = BatchInferencePolicy.class, name = PolicyType.BATCH_INFERENCE_POLICY ),
        @JsonSubTypes.Type( value = EventActionPolicy.class, name = PolicyType.EVENT_ACTION_POLICY ),
        @JsonSubTypes.Type( value = TrainingPolicy.class, name = PolicyType.TRAINING_POLICY ),
        @JsonSubTypes.Type( value = TransformationPolicy.class, name = PolicyType.TRANSFORMATION_POLICY )
})
@JsonDeserialize( using = PolicyDeserializer.class )
@NoArgsConstructor
@Getter
@Setter
public abstract class MLPolicy
{
    private String policyName;
    private boolean savePolicy = true;
    private boolean overwrite;
    private Metadata metadata = new Metadata();

    /**
     * Excludes metadata property in comparison
     * @param o
     * @return boolean
     */
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

        MLPolicy mlPolicy = (MLPolicy) o;

        return new EqualsBuilder().append( savePolicy, mlPolicy.savePolicy ).append( overwrite, mlPolicy.overwrite ).append( policyName,
                mlPolicy.policyName ).isEquals();
    }

    /**
     * Excludes metadata property in comparison.
     * @return int
     */
    @Override
    public int hashCode()
    {
        return new HashCodeBuilder( 17, 37 ).append( policyName ).append( savePolicy ).append( overwrite ).toHashCode();
    }
}
