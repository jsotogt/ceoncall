package ceoncall.service;

import ceoncall.domain.TeamMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertService {

    @Value("${cemail.url}")
    String cemailurl;

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

}
