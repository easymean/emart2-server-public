package com.emart2.redirect.website;

import com.emart2.redirect.type.StageType;
import com.emart2.redirect.website.entity.WebsiteEntity;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

//@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class) //언더 스코어를 공백으로
public class WebsiteTest {

  @Test
  @DisplayName("사이트 생성")
    //권장
  void create_new_website() {
    WebsiteEntity website = new WebsiteEntity();

    assertAll(
        () -> assertNotNull(website),
        () -> assertTrue(website.isActive(), "사이트 생성시 isActive = true"),
        //람다 식으로 만들면 문자열 연산 비용이 들지 않는다.
        () -> assertEquals(StageType.ADMIN, website.getStage(), () -> "JEUS 사이트면 STAGE가 " + StageType.ADMIN)
    );
    System.out.println("create");
  }

  @BeforeAll
  static void beforeAll() {
    System.out.println("before all");
  }

  @AfterAll
  static void afterAll() {
    System.out.println("after all");
  }

  @BeforeEach
  void beforeEach() {
    System.out.println("before each");
  }

  @AfterEach
  void afterEach() {
    System.out.println("after each");
  }
}
