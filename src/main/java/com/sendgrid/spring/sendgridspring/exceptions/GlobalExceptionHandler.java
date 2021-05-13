package com.sendgrid.spring.sendgridspring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler<T> extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NullDetailException.class)
    public ResponseEntity<?> InvitationDetailMissingException() {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", new NullDetailException().getMessage());
        body.put("code",HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>( body, HttpStatus.BAD_REQUEST);
    }

}
