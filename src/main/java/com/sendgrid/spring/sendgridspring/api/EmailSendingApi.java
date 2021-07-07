package com.sendgrid.spring.sendgridspring.api;

import com.sendgrid.spring.sendgridspring.module.EmailModule;
import com.sendgrid.spring.sendgridspring.utils.base.EmailBaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/email")
public interface EmailSendingApi {

    @PostMapping("/verify")
    ResponseEntity<EmailBaseResponse<?>> sendEmail(@RequestBody EmailModule emailModule);
}
