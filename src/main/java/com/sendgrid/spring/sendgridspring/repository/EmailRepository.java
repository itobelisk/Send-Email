package com.sendgrid.spring.sendgridspring.repository;

import com.sendgrid.spring.sendgridspring.module.EmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailEntity, Long> {
}
