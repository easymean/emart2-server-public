package com.emart2.redirect.website.api;

import com.emart2.redirect.common.ApiDocumentationTest;
import com.emart2.redirect.type.StageType;
import com.emart2.redirect.website.application.WebsiteManager;
import com.emart2.redirect.website.dto.ManageWebsiteDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ManageWebsiteControllerTest extends ApiDocumentationTest {

  @MockBean
  protected WebsiteManager websiteManager;

  @Test
  void create() throws Exception {
    ManageWebsiteDto.Response website = ManageWebsiteDto.Response.builder()
        .name("네이버")
        .dev(false)
        .url("www.naver.com")
        .stage(StageType.WEB_FRONT)
        .description("네이버로")
        .build();
    given(websiteManager.createWebsite(any(ManageWebsiteDto.Create.class))).willReturn(website);

    ManageWebsiteDto.Create create = ManageWebsiteDto.Create.builder()
        .name("네이버")
        .dev(false)
        .url("www.naver.com")
        .stage(StageType.WEB_FRONT)
        .description("네이버로")
        .build();

    ResultActions result = mockMvc.perform(post("/admin/websites")
        .accept(MediaType.APPLICATION_JSON)
        .contentType(MediaType.APPLICATION_JSON)
        .content(toJson(create)));


    result.andExpect(status().isCreated())
        .andExpect(header().stringValues("location", "/posts/" + 1L))
        .andDo(print());
  }

}
