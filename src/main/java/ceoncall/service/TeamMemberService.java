package ceoncall.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ceoncall.domain.TeamMember;

@Component
@Transactional
public class TeamMemberService
{
	@PersistenceContext
	EntityManager em;
	
	public List<TeamMember> findAll()
	{
		String jpql = "SELECT t FROM TeamMember t";
		
		TypedQuery<TeamMember> query = em.createQuery(jpql, TeamMember.class);
		
		return query.getResultList();
	}
	
	public void save(TeamMember t)
	{
		em.persist(t);
	}
	
	public TeamMember findById(int id)
	{
		return em.find(TeamMember.class, id);
	}
	
	public TeamMember update(TeamMember t)
	{
		return em.merge(t);
	}
	
	public void delete(TeamMember t)
	{
		em.remove(t);
	}
}
