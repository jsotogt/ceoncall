package ceoncall.web;

import ceoncall.domain.Department;
import ceoncall.domain.Schedule;
import ceoncall.domain.Team;
import ceoncall.domain.TeamMember;
import ceoncall.service.DepartmentService;
import ceoncall.service.ScheduleService;
import ceoncall.service.TeamMemberService;
import ceoncall.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @RequestMapping(value="/schedule/{id}", method=RequestMethod.GET)
    public Schedule get(@PathVariable("id") int id)
    {
        Schedule s = scheduleService.findById(id);

        for( TeamMember t : s.getTeamMemberList()) {
            t.setScheduleList(null);
        }

        return s;
    }

    @RequestMapping(value="/schedule", method=RequestMethod.POST)
    public ResponseEntity<String> create(@RequestBody Schedule s)
    {
        scheduleService.save(s);

        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @RequestMapping(value="/schedule/{id}", method=RequestMethod.PUT)
    public ResponseEntity<String> update(@PathVariable("id") int id, @RequestBody Schedule s)
    {
        Schedule sold = scheduleService.findById(id);

        if(sold == null)
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);

        s.setId(id);

        s = scheduleService.update(s);

        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @RequestMapping(value="/schedule/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("id") int id)
    {
        Schedule s = scheduleService.findById(id);
        if (s == null)
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);

        scheduleService.delete(s);

        return new ResponseEntity<String>(HttpStatus.OK);
    }

}
