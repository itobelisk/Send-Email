package com.sendgrid.spring.sendgridspring.controller;

import com.sendgrid.spring.sendgridspring.api.EmailSendingApi;
import com.sendgrid.spring.sendgridspring.exceptions.NullDetailException;
import com.sendgrid.spring.sendgridspring.notifications.model.EmailRequest;
import com.sendgrid.spring.sendgridspring.notifications.model.EmailResponse;
import com.sendgrid.spring.sendgridspring.service.EmailService;
import com.sendgrid.spring.sendgridspring.type.EmailTypes;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@Log4j2
@Slf4j
public class SendGridEmailController implements EmailSendingApi {

    private final EmailService sendEmailService;

    @Override
    public ResponseEntity<?> sendPlanJava(EmailRequest emailRequest) throws IOException {
        log.info("sendPlanJava {} ", emailRequest.getTo());
        if (emailRequest.getTo() == null) throw new NullDetailException();
        EmailResponse<?> response = sendEmailService.manageEmail(emailRequest);
        return new ResponseEntity<>(response.getData(),HttpStatus.valueOf(response.getCode()));
    }
}
