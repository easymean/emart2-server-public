package com.example.emart2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef = "baseAuditAware")
@SpringBootApplication
public class Emart2Application {

	public static void main(String[] args) {
		SpringApplication.run(Emart2Application.class, args);
	}

}
