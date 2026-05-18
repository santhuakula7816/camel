package com.mapping.jsonmap.service.impl;

import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mapping.jsonmap.dto.ServiceConfig;

@Service
public class ConfigService {

    public ServiceConfig getConfig() {

        try {

            ObjectMapper mapper = new ObjectMapper();

            InputStream inputStream
                    = new ClassPathResource("config/api.json")
                            .getInputStream();

            return mapper.readValue(inputStream, ServiceConfig.class);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
