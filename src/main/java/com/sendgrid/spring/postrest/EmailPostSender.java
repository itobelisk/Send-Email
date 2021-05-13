package com.sendgrid.spring.postrest;

import com.sendgrid.spring.actions.ActionEnums;
import com.sendgrid.spring.actions.EmailActionUrls;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmailPostSender<T> {
    private final EmailActionUrls emailActionUrls;
    private final RestTemplate restTemplate;

    @Async
    public void sendPost(T t, String server, ActionEnums actionEnums) {
        HttpHeaders headers = new HttpHeaders();
        String url = server.concat(emailActionUrls.urlActionPermission(actionEnums));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<T> request = new HttpEntity<>(t, headers);
        restTemplate.postForEntity(url, request, Map.class);
    }
}
