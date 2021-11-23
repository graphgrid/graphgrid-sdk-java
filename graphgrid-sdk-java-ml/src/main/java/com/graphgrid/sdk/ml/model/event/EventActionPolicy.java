package com.graphgrid.sdk.ml.model.event;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.graphgrid.sdk.ml.constant.PolicyType;
import com.graphgrid.sdk.ml.model.MLPolicy;

@JsonAutoDetect
@JsonDeserialize( as = EventActionPolicy.class )
@JsonTypeName( PolicyType.EVENT_ACTION_POLICY )
@NoArgsConstructor
@Getter
@Setter
public class EventActionPolicy
{

    private String cypherCondition;
    private String brokerType;
    private String actionType;
    private MLPolicy policy;

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

        EventActionPolicy that = (EventActionPolicy) o;

        return new EqualsBuilder().append( cypherCondition, that.cypherCondition ).append( brokerType, that.brokerType ).append( actionType,
                that.actionType ).append( policy, that.policy ).isEquals();
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder( 17, 37 ).append( cypherCondition ).append( brokerType ).append( actionType ).append( policy ).toHashCode();
    }
}
