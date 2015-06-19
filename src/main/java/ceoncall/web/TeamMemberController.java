package ceoncall.web;

import java.util.ArrayList;
import java.util.List;

import ceoncall.domain.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ceoncall.domain.TeamMember;
import ceoncall.service.TeamMemberService;

@RestController
public class TeamMemberController
{

	@Autowired
	private TeamMemberService teamMemberService;

    @RequestMapping("/teammember/name")
	public List<String> getAllNames() {

        List<String> names = new ArrayList<>();

        for(TeamMember t : teamMemberService.findAll()) {
            names.add(t.getName());
        }

        return names;

    }
	
    @RequestMapping("/teammembers")
	public List<TeamMember> getAll()
	{

		List<TeamMember> list = teamMemberService.findAll();

		for(TeamMember t : list) {
			t.setScheduleList(null);
		}

		return list;
	}

	@RequestMapping(value="/teammember/{id}", method=RequestMethod.GET)
	public TeamMember get(@PathVariable("id") int id)
	{
		TeamMember t = teamMemberService.findById(id);

		for ( Schedule s : t.getScheduleList()) {
			s.setTeamMemberList(null);
		}

		return t;
	}
  
  @RequestMapping(value="/teammember", method=RequestMethod.POST)
	public ResponseEntity<String> create(@RequestBody TeamMember t)
	{
  	teamMemberService.save(t);
  	
  	return new ResponseEntity<String>(HttpStatus.OK);
	}
  
  @RequestMapping(value="/teammember/{id}", method=RequestMethod.PUT)
	public ResponseEntity<String> update(@PathVariable("id") int id, @RequestBody TeamMember t)
	{
  		TeamMember tOld = teamMemberService.findById(id);
  	
  		if (tOld == null)
  			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
  	
  		t.setId(id);

		TeamMember tNew = teamMemberService.update(t);
		
  		return new ResponseEntity<String>(HttpStatus.OK);
	}
  
  @RequestMapping(value="/teammember/{id}", method=RequestMethod.DELETE)
  public ResponseEntity<String> delete(@PathVariable("id") int id)
  {
  	TeamMember t = teamMemberService.findById(id);
  	if (t == null)
  		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
  	
  	teamMemberService.delete(t);
  	
  	return new ResponseEntity<String>(HttpStatus.OK);
  }
}
