package ceoncall.web;

import ceoncall.domain.Team;
import ceoncall.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {

    @Autowired
    private TeamService teamService;

    @RequestMapping("/teams")
    public List<Team> getAll()
    {
        return teamService.findAll();
    }

    @RequestMapping(value="/team", method= RequestMethod.POST)
    public Team create(@RequestBody Team t)
    {
        teamService.save(t);

        return t;
    }

    @RequestMapping(value="/team/{id}", method=RequestMethod.PUT)
    public Team update(@PathVariable("id") int id, @RequestBody Team t)
    {
        Team told = teamService.findById(id);

        if (told == null)
            return told;

        t.setId(id);

        return teamService.update(t);
    }

    @RequestMapping(value="/team/{id}", method=RequestMethod.GET)
    public Team get(@PathVariable("id") int id)
    {
        return teamService.findById(id);
    }

    @RequestMapping(value="/team/{id}", method=RequestMethod.DELETE)
    public Team delete(@PathVariable("id") int id)
    {
        Team t = teamService.findById(id);

        if (t == null) return null;

        teamService.delete(t);

        return t;
    }
    
}
