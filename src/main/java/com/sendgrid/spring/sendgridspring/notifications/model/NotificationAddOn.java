package com.sendgrid.spring.sendgridspring.notifications.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationAddOn {
    private String emailVerificationCode;
    private String smsVerificationCode;
    private String phoneNumberToNewUSer;
    private String specialTexts;
    private String email;
    private String phoneNumber;
    private String ticketId;
}
