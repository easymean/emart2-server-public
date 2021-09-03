package com.emart2.redirect.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsUtils;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations()); //favicon.ico 요청 무시
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    //http.addFilterBefore(new LoggingFilter(), UsernamePasswordAuthenticationFilter.class);
    http.cors().and().csrf().disable();
    http.authorizeRequests()
        .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
        .mvcMatchers("/auth/login", "/auth/signup").permitAll()
        .mvcMatchers("/admin/**").hasRole("ADMIN")
        //.anyRequest().authenticated()
    ;
  }


}
