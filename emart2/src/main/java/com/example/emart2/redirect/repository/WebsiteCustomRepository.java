package com.example.emart2.redirect.repository;

import com.example.emart2.redirect.entity.Website;

import java.util.List;


public interface WebsiteCustomRepository {
  List<Website> findTop3ByFreq();

  void increaseFreq(Long id);
}
