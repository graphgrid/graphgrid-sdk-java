package com.graphgrid.sdk.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@JsonAutoDetect
@JsonIgnoreProperties( ignoreUnknown = true )
public class Metadata
{
    private String description;
    private String displayName;
    private String createdAt;
    private String updatedAt;
    private List<Policy> versions;

    public Metadata()
    {
        this.createdAt = ZonedDateTime.now().format( DateTimeFormatter.ISO_INSTANT ); // ISO 8601 format
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription( String description )
    {
        this.description = description;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public void setDisplayName( String displayName )
    {
        this.displayName = displayName;
    }

    public String getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt( String createdAt )
    {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt()
    {
        return updatedAt;
    }

    public void setUpdatedAt( String updatedAt )
    {
        this.updatedAt = updatedAt;
    }

    public List<Policy> getVersions()
    {
        return versions;
    }

    public void setVersions( List<Policy> versions )
    {
        this.versions = versions;
    }
}
