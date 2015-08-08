package ceoncall.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ceoncall.domain.Department;

@Service
@Transactional
public class DepartmentService {

    @PersistenceContext
    EntityManager em;

    public List<Department> findAll()
    {
        String jpql = "SELECT d FROM Department d";

        TypedQuery<Department> query = em.createQuery(jpql, Department.class);

        return query.getResultList();
    }

    public void save(Department d)
    {
        em.persist(d);
    }

    public Department findById(int id)
    {
        return em.find(Department.class, id);
    }

    public Department update(Department d)
    {
        return em.merge(d);
    }

    public void delete(Department d)
    {
        em.remove(d);
    }
}
