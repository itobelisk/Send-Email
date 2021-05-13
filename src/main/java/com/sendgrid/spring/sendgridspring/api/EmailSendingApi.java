package com.sendgrid.spring.sendgridspring.api;

import com.sendgrid.spring.sendgridspring.notifications.model.EmailRequest;
import com.sendgrid.spring.sendgridspring.type.EmailTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@RequestMapping("/email/send")
public interface EmailSendingApi {

    @PostMapping("/plan/java")
    ResponseEntity<?> sendPlanJava (@RequestBody EmailRequest emailRequest) throws IOException;
}
