package com.downloader.services.impl;


import com.downloader.services.IRuleBody;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class BaseOutputModel implements IRuleBody {
    @JsonIgnore
    protected String chain;
    @JsonIgnore
    protected String source;
    @JsonIgnore
    protected String modelType;
    @JsonIgnore
    protected String topic;
    @JsonIgnore
    protected String topicStrategy;
    @JsonIgnore
    protected String idStrategy;
    protected String id;
}