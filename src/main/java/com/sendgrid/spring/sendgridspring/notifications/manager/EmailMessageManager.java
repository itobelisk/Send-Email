package com.sendgrid.spring.sendgridspring.notifications.manager;


import com.sendgrid.spring.sendgridspring.notifications.emailsTemplates.EmailTemplates;
import com.sendgrid.spring.sendgridspring.notifications.model.NotificationAddOn;
import com.sendgrid.spring.sendgridspring.notifications.types.NotificationTypes;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmailMessageManager {
    public String getEmailBody(NotificationTypes notificationTypes, NotificationAddOn notificationAddOn) {

        switch (notificationTypes) {
            case registration:
                return EmailTemplates.REGISTRATION_EMAIL_BODY(notificationAddOn);
            default:
                return null;
        }
    }
}
