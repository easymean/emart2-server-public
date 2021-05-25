package com.example.emart2.config;

import com.example.emart2.type.StageType;
import com.example.emart2.type.mapper.EnumMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig{

  @Bean
  public EnumMapper enumMapper(){
    EnumMapper enumMapper = new EnumMapper();
    enumMapper.put("StageType", StageType.class);
    return enumMapper;
  }


  @Bean
  public WebMvcConfigurer corsConfigurer(){
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:3000")
            .allowCredentials(true)
        .allowedMethods(
            HttpMethod.GET.name(),
            HttpMethod.POST.name(),
            HttpMethod.PUT.name(),
            HttpMethod.DELETE.name()
            );
//
//        registry.addMapping("/**")
//            .allowedOrigins("*");
      }
    };
  }


}
