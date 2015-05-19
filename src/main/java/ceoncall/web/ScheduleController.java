package ceoncall.web;

import ceoncall.domain.Department;
import ceoncall.domain.Schedule;
import ceoncall.domain.Team;
import ceoncall.domain.TeamMember;
import ceoncall.service.DepartmentService;
import ceoncall.service.ScheduleService;
import ceoncall.service.TeamMemberService;
import ceoncall.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @RequestMapping(value="/scheduletest", method= RequestMethod.POST)
    public Schedule createOne()
    {

        Schedule s = scheduleService.createOne();

        for( TeamMember t : s.getTeamMemberList()) {
            t.setScheduleList(null);
        }

        return s;

    }
}
