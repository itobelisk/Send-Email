package com.sendgrid.spring.sendgridspring.utils.code;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Slf4j
public class CodeGenerator {

    public String generateStringCode() {
        // create a string of all characters
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // create random string builder
        StringBuilder sb = new StringBuilder();

        // create an object of Random class
        Random random = new Random();

        // specify length of random string
        int length = 7;

        for (int i = 0; i < length; i++) {

            // generate random index number
            int index = random.nextInt(alphabet.length());

            // get character specified by index
            // from the string
            char randomChar = alphabet.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }

        String randomString = sb.toString();
        log.info("Random String is: {} ", randomString);
        return randomString;
    }

    public int generateIntCode() {
        int min = 100000;
        int max = 999999;
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }
}
