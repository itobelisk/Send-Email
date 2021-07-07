package com.sendgrid.spring.sendgridspring;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.constraints.NotNull;


@SpringBootApplication
@Log4j2
@EnableEurekaClient
@EnableJpaRepositories
public class SendgridSpringApplication  extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SendgridSpringApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@NotNull org.springframework.web.servlet.config.annotation.CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE");
            }
        };
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SendgridSpringApplication.class);
    }
}
