package com.graphgrid.sdk.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.graphgrid.sdk.core.model.GraphGridServiceRequest;

@JsonAutoDetect
@JsonIgnoreProperties( ignoreUnknown = true )
public class FindByResourceRequest extends GraphGridServiceRequest
{

    private String resourceGrn;
    private String relationshipType;

    public String getResourceGrn()
    {
        return resourceGrn;
    }

    public void setResourceGrn( String resourceGrn )
    {
        this.resourceGrn = resourceGrn;
    }

    public String getRelationshipType()
    {
        return relationshipType;
    }

    public void setRelationshipType( String relationshipType )
    {
        this.relationshipType = relationshipType;
    }
}
