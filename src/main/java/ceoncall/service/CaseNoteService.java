package ceoncall.service;

import ceoncall.domain.CaseNote;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
@Transactional
public class CaseNoteService {

    @PersistenceContext
    EntityManager em;

    public List<CaseNote> findByScheduleId(Integer id)
    {
        String jpql = "SELECT c FROM CaseNote c INNER JOIN c.schedule s WHERE s.id = :id";

        TypedQuery<CaseNote> query = em.createQuery(jpql, CaseNote.class);
        query.setParameter("id", id);

        return query.getResultList();
    }

    public void save(CaseNote c)
    {
        em.persist(c);
    }

}
