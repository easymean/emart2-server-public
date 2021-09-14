package com.emart2.redirect.config;

import com.emart2.redirect.type.StageType;
import com.emart2.redirect.website.application.mapper.EnumMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAdminConfig {

  @Bean
  public EnumMapper enumMapper() {
    EnumMapper enumMapper = new EnumMapper();
    enumMapper.put("StageType", StageType.class);
    return enumMapper;
  }

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:80", "http://localhost:3000", "http://localhost:8080")
            .allowCredentials(true)
            //.allowedHeaders("*")
            .allowedMethods(
                HttpMethod.GET.name(),
                HttpMethod.POST.name(),
                HttpMethod.PUT.name(),
                HttpMethod.DELETE.name()
            );
      }


    };
  }

}