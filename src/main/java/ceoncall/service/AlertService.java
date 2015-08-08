package ceoncall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AlertService {

    @Value("${cemail.url}")
    String cemailurl;

    @Autowired
    PostmanService postmanService;

    public void email(String alert) {

        String xml = String.format("<SERVICE request_type='SendEMail' from='ceoncall@accesso.com' to='jsoto@accesso.com' message='%s' subject='ceoncall alert' />", alert);

        postmanService.send(cemailurl, xml);

    }

}
