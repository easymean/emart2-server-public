package com.emart2.redirect.config;

import com.emart2.redirect.auth.api.resolver.AdminRequiredResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebAdminConfig implements WebMvcConfigurer{

  private final AdminRequiredResolver adminRequiredResolver;

  public WebAdminConfig(AdminRequiredResolver adminRequiredResolver){
    this.adminRequiredResolver = adminRequiredResolver;
  }

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:80", "http://localhost:4000", "http://localhost:8080")
            .allowCredentials(true)
            .allowedMethods(
                HttpMethod.GET.name(),
                HttpMethod.POST.name(),
                HttpMethod.PUT.name(),
                HttpMethod.DELETE.name()
            );
      }
    };
  }

  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
    resolvers.add(adminRequiredResolver);
  }

}