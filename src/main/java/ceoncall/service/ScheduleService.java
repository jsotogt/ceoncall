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
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Collection;
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

    public List<TeamMember> getOnCall() {

        String jpql = new String("select m from TeamMember m inner join m.scheduleList s where :date between s.startDate and s.endDate");

        TypedQuery<TeamMember> query = em.createQuery(jpql, TeamMember.class);
        query.setParameter("date", new Date());

        return query.getResultList();
    }

}
