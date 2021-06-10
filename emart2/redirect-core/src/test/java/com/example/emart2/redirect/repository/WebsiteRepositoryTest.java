package com.example.emart2.redirect.repository;

import com.emart2.redirect.website.repository.WebsiteRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class WebsiteRepositoryTest {
  @Autowired
  WebsiteRepository websiteRepository;

  @Test
  public void createWebsite(){

  }
}
