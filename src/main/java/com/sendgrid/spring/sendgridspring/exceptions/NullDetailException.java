package com.sendgrid.spring.sendgridspring.exceptions;

public class NullDetailException extends RuntimeException {

    public NullDetailException() {
        super("Details are missing, please fill the required fields");
    }
}
