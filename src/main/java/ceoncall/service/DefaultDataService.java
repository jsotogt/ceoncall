package ceoncall.service;

import ceoncall.domain.TeamMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by jsoto on 4/27/2015.
 */
@Service
public class DefaultDataService {

    @Autowired
    TeamMemberService teamMemberService;

    @PostConstruct
    public void init() {

        if (!teamMemberService.findAll().isEmpty()) {
            return;
        }

        TeamMember tm1 = new TeamMember("Jaime Soto", "M: +1 (407) 330-8085", "jaime.soto@accesso.com");
        teamMemberService.save(tm1);

        TeamMember tm2 = new TeamMember("Jorge Fernandez", "M: +1 (305) 546-4706", "jorge.fernandez@accesso.com");
        teamMemberService.save(tm2);

        TeamMember tm3 = new TeamMember("Jimmy Wong", "M: +1 (407) 443-5990", "jimmy.wong@accesso.com");
        teamMemberService.save(tm3);


    }

}
