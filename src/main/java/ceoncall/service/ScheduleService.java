package ceoncall.service;

import ceoncall.domain.Department;
import ceoncall.domain.Schedule;
import ceoncall.domain.Team;
import ceoncall.domain.TeamMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ScheduleService {

    @PersistenceContext
    EntityManager em;

    @Autowired
    TeamService teamService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    TeamMemberService teamMemberService;

    @Transactional(readOnly = true)
    public Schedule toJson(Schedule s) {

        for( TeamMember t : s.getTeamMemberList()) {
            t.setScheduleList(null);
        }

        return s;

    }

    public Schedule createOne()
    {
        Team team = teamService.findAll().get(0);

        Department department = departmentService.findAll().get(0);

        TeamMember jaime = teamMemberService.findAll().get(0);
        TeamMember jorge = teamMemberService.findAll().get(1);

        List<TeamMember> oncall = new ArrayList<>();
        oncall.add(jaime);
        oncall.add(jorge);

        Schedule schedule = new Schedule();
        schedule.setStartDate(new Date());
        schedule.setEndDate(new Date());
        schedule.setTeam(team);
        schedule.setDepartment(department);
        schedule.setTeamMemberList(oncall);

        jaime.getScheduleList().add(schedule);
        jorge.getScheduleList().add(schedule);

        em.persist(schedule);

        return schedule;
    }
}
