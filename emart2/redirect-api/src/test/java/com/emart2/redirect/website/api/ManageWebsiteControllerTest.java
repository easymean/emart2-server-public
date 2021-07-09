package com.emart2.redirect.website.api;

import com.emart2.redirect.ControllerTestTemplate;
import com.emart2.redirect.common.RestDocsConfiguration;
import com.emart2.redirect.type.StageType;
import com.emart2.redirect.website.application.WebsiteManager;
import com.emart2.redirect.website.dto.ManageWebsiteDto;
import com.emart2.redirect.website.entity.WebsiteEntity;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@AutoConfigureRestDocs
//@Import({RestDocsConfiguration.class})
public class ManageWebsiteControllerTest extends ControllerTestTemplate {

  @MockBean
  WebsiteManager websiteManager;

  @Test
  @DisplayName("웹사이트가 생성된다")
  public void create() throws Exception {
    ManageWebsiteDto.Create website = ManageWebsiteDto.Create.builder()
        .name("test1")
        .description("test description")
        .url("test.com")
        .stage(StageType.WEB_FRONT)
        .dev(true)
        .categoryId(1L)
        .build();

    mockMvc.perform(post("/v1/admin/websites")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .content(toJson(website)))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("id").exists())
        .andExpect(jsonPath("stage").value(Matchers.not(false)))
        .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE));
  }

  @Test
  public void createBadRequest() throws Exception {
    WebsiteEntity website = WebsiteEntity.builder()
        .name("test1")
        .description("test description")
        .url("test.com")
        .stage(StageType.WEB_FRONT)
        .dev(true)
        .build();

    mockMvc.perform(post("/v1/websites")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .content(toJson(website)))
        .andDo(print())
        .andExpect(status().isBadRequest())
    ;
  }

  @Test
  @DisplayName("웹사이트를 조회한다")
  public void getWebsiteById() throws Exception {
    long id = 1L;
    this.mockMvc.perform(get("/v1/admin/websites/" + id)
        .contentType(MediaType.APPLICATION_JSON)
    )
        .andExpect(status().isOk())
        .andExpect(jsonPath("id").exists())
        .andExpect(jsonPath("stage").value(Matchers.not(false)))
        .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE));
  }

}
