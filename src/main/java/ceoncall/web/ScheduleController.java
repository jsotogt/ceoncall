package ceoncall.web;

import ceoncall.domain.Department;
import ceoncall.domain.Schedule;
import ceoncall.domain.Team;
import ceoncall.domain.TeamMember;
import ceoncall.service.DepartmentService;
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

    @PersistenceContext
    EntityManager em;

    @Autowired
    TeamService teamService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    TeamMemberService teamMemberService;

    @RequestMapping(value="/scheduletest", method= RequestMethod.POST)
    @Transactional
    public Schedule createOne()
    {
        Team team = teamService.findAll().get(0);

        Department department = departmentService.findAll().get(0);

        TeamMember teamMember = teamMemberService.findAll().get(0);

        List<TeamMember> oncall = new ArrayList<>();
        oncall.add(teamMember);

        Schedule schedule = new Schedule();
        schedule.setStartDate(new Date());
        schedule.setEndDate(new Date());
        schedule.setTeam(team);
        schedule.setDepartment(department);
        schedule.setTeamMemberList(oncall);

        teamMember.getScheduleList().add(schedule);

        em.persist(schedule);

        return schedule;
    }
}
