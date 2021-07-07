package com.sendgrid.spring.sendgridspring.controller;

import com.sendgrid.spring.sendgridspring.api.EmailSendingApi;
import com.sendgrid.spring.sendgridspring.module.EmailModule;
import com.sendgrid.spring.sendgridspring.service.EmailService;
import com.sendgrid.spring.sendgridspring.utils.base.EmailBaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SendGridEmailController implements EmailSendingApi {

    private final EmailService emailService;

    @Override
    public ResponseEntity<EmailBaseResponse<?>> sendEmail(EmailModule emailModule) {
        boolean isEmailSent = emailService.sendEmailVerificationMessage(emailModule);
        log.info("Email sent {} ", isEmailSent);
        EmailBaseResponse<?> response = new EmailBaseResponse<>(new Date(), isEmailSent, HttpStatus.ACCEPTED);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }
}
