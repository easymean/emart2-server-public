package com.emart2.redirect.user.repository;

import com.emart2.redirect.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
  UserEntity findByUserId(String userId);
}