package com.sendgrid.spring.sendgridspring.module;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailModule {
    private Long userId;
    private String from;
    private String subject;
    private String text;
    private String attachment;

}
