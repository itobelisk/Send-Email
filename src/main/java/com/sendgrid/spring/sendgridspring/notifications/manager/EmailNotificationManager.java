package com.sendgrid.spring.sendgridspring.notifications.manager;

import com.sendgrid.spring.sendgridspring.notifications.model.EmailRequest;
import com.sendgrid.spring.sendgridspring.notifications.model.NotificationAddOn;
import com.sendgrid.spring.sendgridspring.notifications.notificationApi.EmailNotifications;


public class EmailNotificationManager {

    public EmailNotificationManager(EmailNotifications emailNotifications,
                                    NotificationAddOn notificationAddOn,
                                    EmailRequest emailRequest) {
        emailNotifications.sendEmail(notificationAddOn,emailRequest);
    }
}
