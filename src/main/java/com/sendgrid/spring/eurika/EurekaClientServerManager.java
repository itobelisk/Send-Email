package com.sendgrid.spring.eurika;


import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.sendgrid.spring.endpoints.EmailRestEndPoints;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EurekaClientServerManager {
    private InstanceInfo instanceInfo;

    public String serverUrl(EurekaClient eurekaClient){
        instanceInfo =  eurekaClient.getNextServerFromEureka(EmailRestEndPoints.DATA_SERVER, false);
        return instanceInfo.getHomePageUrl();
    }

}
