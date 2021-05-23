package com.example.emart2.redirect.repository;

import com.example.emart2.redirect.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long>{

  Optional<Category> findByIdAndIsActiveIsTrue(Long id);
  List<Category> findAllByIsActiveIsTrue();
}
