package com.sendgrid.spring.sendgridspring.model.base;

import com.sendgrid.spring.sendgridspring.model.messages.AuthorityCheckRequest;
import com.sendgrid.spring.sendgridspring.notifications.model.EmailRequest;
import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseApi {
    private EmailRequest emailRequest;
    private AuthorityCheckRequest checkSecretKey;
}
