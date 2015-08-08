package ceoncall.service;

import ceoncall.domain.TeamMember;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.List;
import com.twilio.sdk.*;
import com.twilio.sdk.resource.factory.*;
import com.twilio.sdk.resource.instance.*;
import com.twilio.sdk.resource.list.*;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

@Service
public class AlertService {

    @Value("${cemail.url}")
    String cemailurl;
    public static final String ACCOUNT_SID = "ACa750cd36c2500269e01cb6aaea0a674e";
    public static final String AUTH_TOKEN = "0d29d164983dffe51957e8f17a203ba0";

    @Autowired
    PostmanService postmanService;

    @Autowired
    ScheduleService scheduleService;

    public void email(String alert) {

        for(TeamMember t : scheduleService.getOnCall()) {

            String xml = String.format("<SERVICE request_type='SendEMail' from='ceoncall@accesso.com' to='%s' message='%s' subject='ceoncall alert' />", t.getEmail(), alert);
            postmanService.send(cemailurl, xml);

        }

    }

    public List<TeamMember> oncall() {

        List<TeamMember> result = scheduleService.getOnCall();

        for (TeamMember m : result) {
            m.setScheduleList(null);
        }

        return result;

    }

    public void sendSMS(String alert) {

        for(TeamMember t : scheduleService.getOnCall()) {
            try {
                TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

                String phone = t.getPhone();

                System.out.println("sending to phone = " + phone);

                // Build the parameters
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("To", phone));
                params.add(new BasicNameValuePair("From", "+13214735401"));
                params.add(new BasicNameValuePair("Body", alert));

                MessageFactory messageFactory = client.getAccount().getMessageFactory();
                Message message = messageFactory.create(params);
                System.out.println(message.getSid());

            } catch (TwilioRestException e) {
                System.out.println(e.getErrorMessage());
            }
        }
    }

}
