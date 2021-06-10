package com.emart2.redirect.website.repository;

import com.emart2.redirect.website.entity.WebsiteEntity;

import java.util.List;

public interface WebsiteCustomRepository {
  List<WebsiteEntity> findFrequentlyUsedWebsiteList(int count);

  void increaseFrequency(Long id);
}
