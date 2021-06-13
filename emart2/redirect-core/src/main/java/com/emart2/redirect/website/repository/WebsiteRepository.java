package com.emart2.redirect.website.repository;

import com.emart2.redirect.website.entity.WebsiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface WebsiteRepository extends JpaRepository<WebsiteEntity, Long>, WebsiteCustomRepository {
  Optional<WebsiteEntity> findByIdAndIsActiveIsTrue(Long id);

  List<WebsiteEntity> findAllByIsActiveIsTrue();

  List<WebsiteEntity> findAllByNameContainsAndIsActiveTrue(String keyword);
}
