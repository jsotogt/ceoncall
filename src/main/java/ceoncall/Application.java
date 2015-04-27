package ceoncall;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ceoncall.domain.TeamMember;

@SpringBootApplication
public class Application {

    public static void main(String[] args) 
    {
        SpringApplication.run(Application.class, args);
    }

}