package com.graphgrid.sdk.ml.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@JsonAutoDetect
@Getter
@Setter
public abstract class MLPolicy
{
    private String policyName;
    private boolean savePolicy = true;
    private boolean overwrite;
    private Metadata metadata = new Metadata();

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

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder( 17, 37 ).append( policyName ).append( savePolicy ).append( overwrite ).toHashCode();
    }
}
