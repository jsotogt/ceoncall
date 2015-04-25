package ceoncall;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ceoncall.domain.TeamMember;

@SpringBootApplication
public class Application {
	
  	@PersistenceContext
  	EntityManager em;

    public static void main(String[] args) 
    {
        SpringApplication.run(Application.class, args);
    }
    
    public void addDefaultTeamMembers()
    {
      String jpql = "SELECT t FROM TeamMember t";
  		
  		TypedQuery<TeamMember> query = em.createQuery(jpql, TeamMember.class);
  		
  		if (!query.getResultList().isEmpty())
  			return;
  		
  		TeamMember t1 = new TeamMember("Matt Damon", "123456", "tehdamon@accesso.com");
  		TeamMember t2 = new TeamMember("Matt Damon2", "987654", "tehdamon2@accesso.com");
  		TeamMember t3 = new TeamMember("Matt Damon3", "645789", "tehdamon3@accesso.com");

  		em.persist(t1);
  		em.persist(t2);
  		em.persist(t3);
    }
}