package com.sendgrid.spring.sendgridspring.notifications.manager;

import com.sendgrid.spring.sendgridspring.notifications.constances.EmailSubjects;
import com.sendgrid.spring.sendgridspring.notifications.types.NotificationTypes;

public class EmailSubjectManager {

    public String emailSubject(NotificationTypes notificationTypes) {

        switch (notificationTypes) {
            case registration:
                return EmailSubjects.NEW_USER_REGISTRATION_SUBJECT;
            default:
                return null;
        }
    }
}
