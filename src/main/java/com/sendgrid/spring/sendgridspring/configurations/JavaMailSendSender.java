package com.sendgrid.spring.sendgridspring.configurations;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Properties;
@Component
@RequiredArgsConstructor
@Log4j2
public class JavaMailSendSender {

    @Bean
    public JavaMailSenderImpl getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.sendgrid.net");
        mailSender.setPort(587);
        mailSender.setUsername("apikey");// dont change it
//        mailSender.setPassword("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");
        mailSender.setPassword("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");
        //properties for send grid smtp connections and configuration
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        return mailSender;
    }

}
