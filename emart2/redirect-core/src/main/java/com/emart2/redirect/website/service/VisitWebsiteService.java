package com.emart2.redirect.website.service;

import com.emart2.redirect.website.repository.WebsiteRepository;
import org.springframework.stereotype.Service;

@Service
public class VisitWebsiteService {

  private final WebsiteRepository websiteRepository;

  public VisitWebsiteService(WebsiteRepository websiteRepository) {
    this.websiteRepository = websiteRepository;
  }

  public void increaseFrequencyById(Long id) {
    websiteRepository.increaseFrequency(id);
  }
}
