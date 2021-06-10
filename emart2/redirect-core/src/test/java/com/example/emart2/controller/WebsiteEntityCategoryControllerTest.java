package com.example.emart2.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class WebsiteEntityCategoryControllerTest extends AbstractMockMvcTestBoilerplate {

  @Test
  @DisplayName("책정보가 조회된다")
  void success__when__책정보가_조회된다() throws Exception {
    // given
    long id = 1L;
    // when then
    mvc.perform(get("/books/" + id))
        .andExpect(status().is(HttpStatus.OK.value()))
        .andExpect(content().contentType(APPLICATION_JSON))
        .andExpect(jsonPath("$.data.id").value(1L))
        .andExpect(jsonPath("$.data.price").exists())
        .andExpect(jsonPath("$.data.name").exists())
        .andExpect(jsonPath("$.data.isbn").exists());
  }

}
