package com.sendgrid.spring.sendgridspring.service;


import com.sendgrid.spring.sendgridspring.notifications.model.EmailRequest;
import com.sendgrid.spring.sendgridspring.notifications.model.EmailResponse;
import com.sendgrid.spring.sendgridspring.type.EmailTypes;
import org.springframework.http.ResponseEntity;


public interface EmailService {

    EmailResponse<?> manageEmail(EmailRequest emailRequest);

}
