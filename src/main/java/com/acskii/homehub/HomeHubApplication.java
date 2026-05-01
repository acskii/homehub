package com.acskii.homehub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HomeHubApplication {
	public static void main(String[] args) {
		SpringApplication.run(HomeHubApplication.class, args);
	}
}
