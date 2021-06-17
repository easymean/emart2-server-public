package com.emart2.redirect.common;

import com.emart2.redirect.website.api.ManageWebsiteController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(controllers = {
    ManageWebsiteController.class
})
@AutoConfigureRestDocs(uriHost = "localhost:8080")
public abstract class ApiDocumentationTest {
  @Autowired
  protected MockMvc mockMvc;

  protected final ObjectWriter objectWriter = new ObjectMapper().writer();

  @Autowired
  private WebApplicationContext ctx;

  @BeforeEach
  void setUp() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx)
        .addFilters(new CharacterEncodingFilter("UTF-8", true))
        .alwaysDo(print())
        .build();
  }

  protected <T> String toJson(T obj) throws JsonProcessingException {
    return objectWriter.writeValueAsString(obj);
  }

}
