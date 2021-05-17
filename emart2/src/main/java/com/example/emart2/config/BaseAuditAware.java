package com.example.emart2.config;

import com.example.emart2.entity.BaseEntity;
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
