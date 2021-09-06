package com.emart2.redirect.config;

import com.emart2.redirect.config.security.JwtTokenFilter;
import com.emart2.redirect.config.security.JwtTokenProvider;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  private final JwtTokenProvider jwtTokenProvider;

  public SecurityConfig(JwtTokenProvider jwtTokenProvider) {
    this.jwtTokenProvider = jwtTokenProvider;
  }


  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations()); //favicon.ico 요청 무시
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    //http.addFilterBefore(new JwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    http.cors().and()
        .csrf().disable()
        .httpBasic().disable()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // 세션 사용하지 않음
    http.authorizeRequests()
        .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
        .mvcMatchers("/auth/login", "/auth/signup").permitAll() // 로그인 회원가입 페이지만 접근 가능
        .mvcMatchers("/admin/**").hasRole("ADMIN")
        .anyRequest().authenticated() // 서비스 이용을 위해선 인증받은 사용자만 허가 가능
    .and()
      .addFilterBefore(new JwtTokenFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class)
    ;
  }


}
