package ceoncall.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ceoncall.domain.Team;

@Service
@Transactional
public class TeamService {

    @PersistenceContext
    EntityManager em;

    public List<Team> findAll()
    {
        String jpql = "SELECT t FROM Team t";

        TypedQuery<Team> query = em.createQuery(jpql, Team.class);

        return query.getResultList();
    }

    public void save(Team t)
    {
        em.persist(t);
    }

    public Team findById(int id)
    {
        return em.find(Team.class, id);
    }

    public Team update(Team t)
    {
        return em.merge(t);
    }

    public void delete(Team t)
    {
        em.remove(t);
    }
}
