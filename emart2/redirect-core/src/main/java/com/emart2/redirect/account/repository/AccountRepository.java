package com.emart2.redirect.account.repository;

import com.emart2.redirect.account.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
  Optional<AccountEntity> findByIdAndIsActiveIsTrue(Long id);
}
