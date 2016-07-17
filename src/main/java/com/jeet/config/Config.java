package com.jeet.config;


import com.jeet.api.ExecutionPolicy;

import javax.xml.bind.annotation.*;

/**
 * Created by Aroras on 7/6/2016.
 */
@XmlRootElement
public class Config {

    private ExecutionPolicy executionPolicy;
    public ExecutionPolicy getExecutionPolicy() {
        return executionPolicy;
    }
    @XmlElement(name = "executionPolicy")
    public void setExecutionPolicy(ExecutionPolicy executionPolicy) {
        this.executionPolicy = executionPolicy;
    }
}
