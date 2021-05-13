package com.sendgrid.spring.sendgridspring.configurations;

import com.sendgrid.SendGrid;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.sendgrid.SendGridProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@Log4j2
public class GridMailSender extends SendGrid{

    public GridMailSender(@Value("{sendgrid.api.key}")String apiKey) {
        super(apiKey);
        log.info("secret--------------------> {} " + apiKey);
    }
}
