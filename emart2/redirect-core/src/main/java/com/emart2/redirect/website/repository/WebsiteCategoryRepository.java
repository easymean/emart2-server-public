package com.emart2.redirect.website.repository;

import com.emart2.redirect.website.entity.WebsiteCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WebsiteCategoryRepository extends JpaRepository<WebsiteCategoryEntity, Long> {

  Optional<WebsiteCategoryEntity> findByIdAndIsActiveIsTrue(Long id);

  List<WebsiteCategoryEntity> findAllByIsActiveIsTrue();
}
