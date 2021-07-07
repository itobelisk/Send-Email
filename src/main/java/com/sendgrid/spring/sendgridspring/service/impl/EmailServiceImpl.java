package com.sendgrid.spring.sendgridspring.service.impl;

import com.sendgrid.spring.sendgridspring.module.EmailEntity;
import com.sendgrid.spring.sendgridspring.module.EmailModule;
import com.sendgrid.spring.sendgridspring.repository.EmailRepository;
import com.sendgrid.spring.sendgridspring.service.EmailService;
import com.sendgrid.spring.sendgridspring.utils.code.CodeGenerator;
import com.sendgrid.spring.sendgridspring.utils.templates.EmailTemplates;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service("EmailService")
@Slf4j
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private final EmailTemplates emailTemplates;
    private static final String NOREPLY_ADDRESS = "info@digisoft-it.com";
    private static final String VERIFICATION_EMAIL_SUBJECT = "PLease verify your email.";
    private final JavaMailSender emailSender;
    private final CodeGenerator codeGenerator;
    private final EmailRepository emailRepository;

    public boolean sendSimpleMessage(EmailModule emailModule) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailModule.getFrom());
            message.setTo(NOREPLY_ADDRESS);
            message.setSubject(emailModule.getSubject());
            message.setText(emailModule.getText());

            emailSender.send(message);
        } catch (MailException e) {
            log.error("Email sent exception {} ", e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean sendMessageWithAttachment(EmailModule emailModule) {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            // pass 'true' to the constructor to create a multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(emailModule.getFrom());
            helper.setTo(NOREPLY_ADDRESS);
            helper.setSubject(emailModule.getSubject());
            helper.setText(emailModule.getText());

            FileSystemResource file = new FileSystemResource(new File(emailModule.getAttachment()));
            helper.addAttachment("Invoice", file);

            emailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
            log.error("Email sent exception {} ", e.getMessage());
            return false;
        }
        return true;
    }


    @Override
    @SneakyThrows
    public boolean sendHtmlMessage(EmailModule emailModule) {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setFrom(NOREPLY_ADDRESS);
            helper.setTo(emailModule.getFrom());
            helper.setSubject(emailModule.getSubject());

//            String emailTemplate = emailTemplates.webMailTemplateToDigiSoft(emailModule.getText());
//            helper.setText(emailTemplate, true);
            emailSender.send(message);

        } catch (Exception e) {
            log.error("Email sent exception {} ", e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean sendEmailVerificationMessage(EmailModule emailModule) {
        try {
            String verificationCode =String.valueOf(codeGenerator.generateIntCode());
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setFrom(NOREPLY_ADDRESS);
            helper.setTo(emailModule.getFrom());
            helper.setSubject(VERIFICATION_EMAIL_SUBJECT);
            emailModule.setText(verificationCode);
            String emailTemplate = emailTemplates.webMailEmailVerificationTemplate(emailModule.getText());
            helper.setText(emailTemplate, true);
            emailSender.send(message);

            EmailEntity emailEntity = new EmailEntity();
            emailEntity.setAttachment("No Attachment");
            emailEntity.setSubject(VERIFICATION_EMAIL_SUBJECT);
            emailEntity.setFrom(emailModule.getFrom());
            emailEntity.setTo(NOREPLY_ADDRESS);
            emailEntity.setText(verificationCode);
            emailEntity.setUserId(emailModule.getUserId());

            emailRepository.save(emailEntity);

        } catch (Exception e) {
            log.error("Email sent exception {} ", e.getMessage());
            return false;
        }
        return true;
    }
}