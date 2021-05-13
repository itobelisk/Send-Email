package com.sendgrid.spring.sendgridspring.notifications.notificationApi;

import com.sendgrid.spring.sendgridspring.notifications.model.EmailRequest;
import com.sendgrid.spring.sendgridspring.notifications.model.NotificationAddOn;

@FunctionalInterface
public interface EmailNotifications {
    void sendEmail(NotificationAddOn notificationAddOn,EmailRequest emailRequest);
}
