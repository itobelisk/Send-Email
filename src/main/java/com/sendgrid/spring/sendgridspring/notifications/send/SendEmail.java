package com.sendgrid.spring.sendgridspring.notifications.send;


import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.spring.sendgridspring.notifications.model.EmailRequest;
import com.sendgrid.spring.sendgridspring.notifications.model.EmailResponse;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class SendEmail {
    @SneakyThrows
    public static void sendJavaResponse(EmailRequest emailRequest) {
        Email from = new Email(emailRequest.getFrom());
        Email to = new Email(emailRequest.getTo());
        String subject = emailRequest.getSubject();
        Content content = new Content("text/html", emailRequest.getBody());
        Mail mail = new Mail(from, subject, to, content);
//        SendGrid sg = new SendGrid("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");
        SendGrid sg = new SendGrid("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");
        Request request = new Request();
        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());
        if (!emailRequest.getTo().equals("")) {
            Response response = sg.api(request);
        }
        new EmailResponse<>(true, "email sent successfully.", 200);
    }

}
