package com.sendgrid.spring.sendgridspring.notifications.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sendgrid.spring.sendgridspring.type.EmailTypes;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class EmailRequest{
    private String to;
    private String from;
    private String subject;
    private String body;
    private String cc;
    private String bcc;
    @SerializedName("type")
    @Expose
    private EmailTypes type;

}