package com.emart2.redirect.common;

import com.emart2.redirect.common.entity.BaseEntity;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BaseAuditAware implements AuditorAware<BaseEntity> {

  @Override
  public Optional<BaseEntity> getCurrentAuditor() {
    return Optional.empty();
  }
}
