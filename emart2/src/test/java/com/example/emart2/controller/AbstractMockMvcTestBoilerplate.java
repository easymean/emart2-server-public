package com.example.emart2.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Transactional
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class AbstractMockMvcTestBoilerplate {
  protected MockMvc mvc;

  @Autowired
  private WebApplicationContext ctx;

  protected final String APPLICATION_JSON = "application/json;charset=UTF-8";
  protected final String USER_HEADER = "X-USER-ID";

  protected final String JSON_EMPTY_STRING = "{}";

  protected final ObjectWriter objectWriter = new ObjectMapper().writer();

  @BeforeEach
  void setUp() {
    this.mvc = MockMvcBuilders.webAppContextSetup(ctx)
        .addFilters(new CharacterEncodingFilter("UTF-8", true))
        .alwaysDo(print())
        .build();
  }

  @SneakyThrows
  protected <T> String toJson(T obj) throws JsonProcessingException {
    return objectWriter.writeValueAsString(obj);
  }
}
