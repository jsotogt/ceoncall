package ceoncall.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ceoncall.domain.Schedule;

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

}
