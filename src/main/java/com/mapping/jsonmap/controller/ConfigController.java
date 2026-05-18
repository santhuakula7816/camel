package com.mapping.jsonmap.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mapping.jsonmap.dto.ServiceConfig;
import com.mapping.jsonmap.service.impl.ConfigService;

@RestController
public class ConfigController {

    private final ConfigService configService;

    public ConfigController(ConfigService configService) {
        this.configService = configService;
    }

    @GetMapping("/api/config")
    public ServiceConfig getConfig() {
        return configService.getConfig();
    }
}