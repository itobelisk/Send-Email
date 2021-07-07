package com.sendgrid.spring.sendgridspring.service;


import com.sendgrid.spring.sendgridspring.module.EmailModule;

public interface EmailService {
    boolean sendSimpleMessage(EmailModule emailModule);

    boolean sendMessageWithAttachment(EmailModule emailModule);

    boolean sendHtmlMessage(EmailModule emailModule);

    boolean sendEmailVerificationMessage(EmailModule emailModule);
}
