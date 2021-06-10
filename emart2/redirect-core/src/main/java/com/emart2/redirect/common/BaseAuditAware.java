package com.emart2.redirect.common;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BaseAuditAware implements AuditorAware<BaseEntity> {

  @Override
  public Optional<BaseEntity> getCurrentAuditor() {
    System.out.println("현재 유저");
    return Optional.empty();
  }
}
