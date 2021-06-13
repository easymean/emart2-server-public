package com.emart2.redirect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class Emart2Application {
  public static void main(String[] args) {
    SpringApplication.run(Emart2Application.class, args);
  }

}
