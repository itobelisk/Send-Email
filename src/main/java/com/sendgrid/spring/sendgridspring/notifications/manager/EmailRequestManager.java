package com.sendgrid.spring.sendgridspring.notifications.manager;


import com.sendgrid.spring.sendgridspring.notifications.model.EmailRequest;

public class EmailRequestManager {

    private static final String FROM_EMAIL = "hello@litparty.app";

    public static EmailRequest buildRequest(String message, String subject,String to){
        return EmailRequest.builder()
                .body(message)
                .subject(subject)
                .to(to)
                .from(FROM_EMAIL)
                .build();
    }

}
