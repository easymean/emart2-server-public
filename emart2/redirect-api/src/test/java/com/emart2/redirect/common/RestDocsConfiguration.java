package com.emart2.redirect.common;

import org.springframework.boot.test.autoconfigure.restdocs.RestDocsMockMvcConfigurationCustomizer;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;


@TestConfiguration
public class RestDocsConfiguration {

  @Bean //asciidocs 예쁘게 출력
  public RestDocsMockMvcConfigurationCustomizer restDocsMockMvcConfigurationCustomizer(){
    return configurer -> configurer.operationPreprocessors()
        .withRequestDefaults(prettyPrint())
        .withResponseDefaults(prettyPrint());
  }
}
