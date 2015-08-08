package ceoncall.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ceoncall.domain.Team;
import ceoncall.service.TeamService;

@RestController
public class TeamController {

    @Autowired
    private TeamService teamService;

    @RequestMapping("/teams")
    public List<Team> getAll()
    {
        return teamService.findAll();
    }

    @RequestMapping("/team/name")
    public List<String> getAllNames() {

        List<String> names = new ArrayList<>();

        for(Team t : teamService.findAll()) {
            names.add(t.getName());
        }

        return names;

    }

    @RequestMapping(value="/team/{id}", method=RequestMethod.GET)
    public Team get(@PathVariable("id") int id)
    {
        return teamService.findById(id);
    }

    @RequestMapping(value="/team", method= RequestMethod.POST)
    public ResponseEntity<String> create(@RequestBody Team t)
    {
        teamService.save(t);

        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @RequestMapping(value="/team/{id}", method=RequestMethod.PUT)
    public ResponseEntity<String> update(@PathVariable("id") int id, @RequestBody Team t)
    {
        Team told = teamService.findById(id);

        if (told == null)
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);

        t.setId(id);
        teamService.update(t);

        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @RequestMapping(value="/team/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("id") int id)
    {
        Team t = teamService.findById(id);

        if (t == null) return new ResponseEntity<String>(HttpStatus.NOT_FOUND);

        teamService.delete(t);

        return new ResponseEntity<String>(HttpStatus.OK);
    }
    
}
