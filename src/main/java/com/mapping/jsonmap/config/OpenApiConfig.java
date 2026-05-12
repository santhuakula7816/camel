package com.mapping.jsonmap.config;


import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        Server server = new Server();

        server.setUrl("{{baseUrl}}");
        server.setDescription(
                "Dynamic base URL from environment"
        );

        return new OpenAPI()
                .servers(List.of(server));
    }
}
