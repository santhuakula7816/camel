package com.mapping.jsonmap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class JsonmapApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonmapApplication.class, args);
	}

}
