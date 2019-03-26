package com.graphgrid.sdk.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.graphgrid.sdk.core.model.GraphGridServiceRequest;

@JsonAutoDetect
@JsonIgnoreProperties( ignoreUnknown = true )
public class CreateRelationshipRequest extends GraphGridServiceRequest
{

    private String fileGrn;
    private String resourceGrn;
    private String relationshipType;
    private String relationshipDirection;

    public String getFileGrn()
    {
        return fileGrn;
    }

    public void setFileGrn( String fileGrn )
    {
        this.fileGrn = fileGrn;
    }

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

    public String getRelationshipDirection()
    {
        return relationshipDirection;
    }

    public void setRelationshipDirection( String relationshipDirection )
    {
        this.relationshipDirection = relationshipDirection;
    }
}
