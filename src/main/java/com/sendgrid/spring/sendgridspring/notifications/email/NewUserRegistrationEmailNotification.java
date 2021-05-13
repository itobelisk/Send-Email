package com.sendgrid.spring.sendgridspring.notifications.email;
import com.sendgrid.spring.sendgridspring.notifications.manager.EmailMessageManager;
import com.sendgrid.spring.sendgridspring.notifications.manager.EmailRequestManager;
import com.sendgrid.spring.sendgridspring.notifications.manager.EmailSubjectManager;
import com.sendgrid.spring.sendgridspring.notifications.model.EmailRequest;
import com.sendgrid.spring.sendgridspring.notifications.model.NotificationAddOn;
import com.sendgrid.spring.sendgridspring.notifications.notificationApi.EmailNotifications;

import com.sendgrid.spring.sendgridspring.notifications.send.SendEmail;
import com.sendgrid.spring.sendgridspring.notifications.types.NotificationTypes;

public class NewUserRegistrationEmailNotification implements EmailNotifications {

    @Override
    public void sendEmail(NotificationAddOn notificationAddOn,EmailRequest emailRequest) {
        String message = new EmailMessageManager().getEmailBody(NotificationTypes.registration,notificationAddOn);
        String subject = new EmailSubjectManager().emailSubject(NotificationTypes.registration);
        EmailRequest sendEmailObject = EmailRequestManager.buildRequest(message,subject,emailRequest.getTo());
        assert false;
        SendEmail.sendJavaResponse(sendEmailObject);
    }
}
