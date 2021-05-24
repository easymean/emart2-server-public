package com.example.emart2.redirect.repository;

import com.example.emart2.redirect.entity.Website;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface WebsiteRepository extends JpaRepository<Website, Long>, WebsiteCustomRepository {
  Optional<Website> findByIdAndIsActiveIsTrue(Long id);

  List<Website> findAllByIsActiveIsTrue();
}
