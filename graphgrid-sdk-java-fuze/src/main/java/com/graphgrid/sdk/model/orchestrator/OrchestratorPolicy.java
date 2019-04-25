package com.graphgrid.sdk.model.orchestrator;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

import com.graphgrid.sdk.model.Policy;

@JsonAutoDetect
@JsonIgnoreProperties( ignoreUnknown = true )
public class OrchestratorPolicy implements Policy
{
    private Map<String,Object> metadata;
    private List<Task> tasks;

    public OrchestratorPolicy()
    {
    }

    public Map<String,Object> getMetadata()
    {
        return metadata;
    }

    public void setMetadata( Map<String,Object> metadata )
    {
        this.metadata = metadata;
    }

    public List<Task> getTasks()
    {
        return tasks;
    }

    public void setTasks( List<Task> tasks )
    {
        this.tasks = tasks;
    }

    @JsonAutoDetect
    @JsonIgnoreProperties( ignoreUnknown = true )
    public class Task
    {
        private Map<String,Object> metadata;
        private FuzeComponent fuzeComponent;
        private Policy policy;
        private List<String> receiveFrom;
        private List<String> sendTo;

        public Task()
        {
        }

        public Map<String,Object> getMetadata()
        {
            return metadata;
        }

        public void setMetadata( Map<String,Object> metadata )
        {
            this.metadata = metadata;
        }

        public FuzeComponent getFuzeComponent()
        {
            return fuzeComponent;
        }

        public void setFuzeComponent( FuzeComponent fuzeComponent )
        {
            this.fuzeComponent = fuzeComponent;
        }

        public Policy getPolicy()
        {
            return policy;
        }

        public void setPolicy( Policy policy )
        {
            this.policy = policy;
        }

        public List<String> getReceiveFrom()
        {
            return receiveFrom;
        }

        public void setReceiveFrom( List<String> receiveFrom )
        {
            this.receiveFrom = receiveFrom;
        }

        public List<String> getSendTo()
        {
            return sendTo;
        }

        public void setSendTo( List<String> sendTo )
        {
            this.sendTo = sendTo;
        }
    }

    public enum FuzeComponent
    {
        @JsonProperty( "ApocTrigger" )
        APOC_TRIGGER,
        @JsonProperty( "Distributor" )
        DISTRIBUTOR,
        @JsonProperty( "Worker" )
        WORKER,
        @JsonProperty( "External" )
        EXTERNAL,
        @JsonProperty( "Neo4jWriter" )
        NEO4JWRITER
    }
}
