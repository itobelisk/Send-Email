package com.sendgrid.spring.sendgridspring.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Base64;

@Component
public class EncodingDecoding {
    private static final Logger LOGGER = LoggerFactory.getLogger(EncodingDecoding.class);

    public String encodePath(String path){
        String encoded = "";
        try {
            encoded = Base64.getEncoder().encodeToString(path.getBytes());
        }catch(Exception e) {
            LOGGER.error("Error encoding parameter {}", e.getMessage(), e);
        }
        return encoded;
    }

    public String decodePath(String path){
        String encoded = "";
        try {
            byte[] bytes = Base64.getDecoder().decode(path.getBytes());
            encoded = new String(bytes);
        }catch(Exception e) {
            LOGGER.error("Error encoding parameter {}", e.getMessage(), e);
        }
        return encoded;
    }

}
