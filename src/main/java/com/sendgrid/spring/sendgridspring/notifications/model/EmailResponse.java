package com.sendgrid.spring.sendgridspring.notifications.model;

import com.sendgrid.Response;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailResponse<T> extends Response {
    private boolean status;
    private T data;
    private int code;

}