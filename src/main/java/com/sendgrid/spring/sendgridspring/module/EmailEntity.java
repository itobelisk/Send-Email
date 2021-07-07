package com.sendgrid.spring.sendgridspring.module;

import com.sendgrid.spring.sendgridspring.utils.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "likes")
public class EmailEntity extends BaseEntity {
    private Long userId;
    @Column(name="valueFrom")
    private String from;
    @Column(name="valueTo")
    private String to;
    private String subject;
    private String text;
    private String attachment;
}
