package com.sendgrid.spring.sendgridspring.serviceImplimentation;

import com.sendgrid.spring.sendgridspring.notifications.email.NewUserRegistrationEmailNotification;
import com.sendgrid.spring.sendgridspring.notifications.manager.EmailNotificationManager;
import com.sendgrid.spring.sendgridspring.notifications.model.EmailRequest;
import com.sendgrid.spring.sendgridspring.notifications.model.EmailResponse;
import com.sendgrid.spring.sendgridspring.notifications.model.NotificationAddOn;
import com.sendgrid.spring.sendgridspring.service.EmailService;
import com.sendgrid.spring.sendgridspring.type.EmailTypes;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class SendEmailServiceImplementation implements EmailService {


    @Override
    public EmailResponse<?> manageEmail(EmailRequest emailRequest) {
        EmailResponse<?> response = emailTypeManager(emailRequest.getType(),emailRequest);
        return new EmailResponse<>(true, "Email send", HttpStatus.OK.value());
    }

    private EmailResponse<?> emailTypeManager(EmailTypes type, EmailRequest emailRequest) {
        switch (type) {
            case REGISTRATION:
                NotificationAddOn notificationAddOn = new NotificationAddOn();
                new EmailNotificationManager(new NewUserRegistrationEmailNotification(), notificationAddOn,emailRequest);
        }
        return null;
    }


}
