package com.sendgrid.spring.sendgridspring.model.messages;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sendgrid.Response;
import com.sendgrid.spring.sendgridspring.configurations.GridMailSender;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthorityCheckRequest {
    private String name;
    private String api_key_id;

}
