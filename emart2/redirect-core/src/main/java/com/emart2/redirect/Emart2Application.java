package com.emart2.redirect;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef = "baseAuditAware")
public class Emart2Application {
}
