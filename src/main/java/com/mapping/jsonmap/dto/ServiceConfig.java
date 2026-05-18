package com.mapping.jsonmap.dto;

import java.util.Map;

public class ServiceConfig {

    private String serviceName;

    private String version;

    private Map<String, EnvironmentConfig> environments;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Map<String, EnvironmentConfig> getEnvironments() {
        return environments;
    }

    public void setEnvironments(Map<String, EnvironmentConfig> environments) {
        this.environments = environments;
    }
}
