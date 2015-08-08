package ceoncall.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ceoncall.domain.Department;
import ceoncall.domain.Team;
import ceoncall.domain.TeamMember;

@Service
public class DefaultDataService {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    TeamService teamService;

    @Autowired
    TeamMemberService teamMemberService;

    @PostConstruct
    public void init() {

        if (!departmentService.findAll().isEmpty()) {
            return;
        }

        createDepartments();

        createTeams();

        createTeamMembers();

    }

    public void createTeamMembers() {
        TeamMember jaime = new TeamMember("Jaime Soto", "M: +1 (407) 330-8085", "jaime.soto@accesso.com");
        teamMemberService.save(jaime);

        TeamMember jimmy = new TeamMember("Jorge Fernandez", "M: +1 (305) 546-4706", "jorge.fernandez@accesso.com");
        teamMemberService.save(jimmy);

        TeamMember jorge = new TeamMember("Jimmy Wong", "M: +1 (407) 443-5990", "jimmy.wong@accesso.com");
        teamMemberService.save(jorge);
    }

    public void createDepartments() {
        Department dev = new Department("Development");
        departmentService.save(dev);

        Department ops = new Department("Operations");
        departmentService.save(ops);

        Department it = new Department("IT");
        departmentService.save(it);
    }

    public void createTeams() {
        Team backend = new Team("Backend");
        teamService.save(backend);

        Team v4 = new Team("Client UI (V4)");
        teamService.save(v4);

        Team v5 = new Team("Client UI (V5)");
        teamService.save(v5);

        Team sixflags = new Team("Sixflags");
        teamService.save(sixflags);

        Team cedar = new Team("Cedar Fair");
        teamService.save(cedar);
    }

}
