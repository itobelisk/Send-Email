package com.sendgrid.spring.actions;

import com.sendgrid.spring.endpoints.EmailRestEndPoints;
import org.springframework.stereotype.Component;

@Component
public class EmailActionUrls {


    public String urlActionPermission(ActionEnums actionEnums){
        switch (actionEnums){
            case single:return EmailRestEndPoints.EMAIL_TEMPLATE;
            default:return "something is missing inside endpoint for permission category";
        }
    }
}
