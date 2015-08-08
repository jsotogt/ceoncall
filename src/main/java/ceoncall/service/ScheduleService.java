package ceoncall.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ceoncall.domain.Schedule;
import ceoncall.domain.TeamMember;

@Service
@Transactional
public class ScheduleService
{

	@PersistenceContext
	EntityManager em;

	@Autowired
	TeamService teamService;

	@Autowired
	DepartmentService departmentService;

	@Autowired
	TeamMemberService teamMemberService;

	/**
	 * Returns a list of team members that were on call for the department between the start and end times
	 */
	public List<TeamMember> getOnCall(int id, Date start, Date end)
	{

		String jpql = "SELECT s FROM Schedule s WHERE s.department = :department AND s.startDate >= :startDate AND s.endDate <= :endDate";

		TypedQuery<Schedule> query = em.createQuery(jpql, Schedule.class);
		query.setParameter("department", departmentService.findById(id));
		query.setParameter("startDate", start);
		query.setParameter("endDate", end);
		List<Schedule> list = query.getResultList();

		List<TeamMember> team_list = new ArrayList<TeamMember>();
		for (Schedule s : list)
		{
			team_list.addAll(s.getTeamMemberList());
		}

		return team_list;
	}

	public void save(Schedule s)
	{
		em.persist(s);
	}

	public Schedule update(Schedule s)
	{
		return em.merge(s);
	}

	public void delete(Schedule s)
	{
		em.remove(s);
	}

	public Schedule findById(int id)
	{
		return em.find(Schedule.class, id);
	}

}
