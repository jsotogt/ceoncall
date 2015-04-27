package ceoncall.service;

import ceoncall.domain.Department;
import ceoncall.domain.TeamMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class DefaultDataService {

    @Autowired
    TeamMemberService teamMemberService;

    @Autowired
    DepartmentService departmentService;

    @PostConstruct
    public void init() {

        if (!teamMemberService.findAll().isEmpty()) {
            return;
        }

        createDepartments();

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

}
