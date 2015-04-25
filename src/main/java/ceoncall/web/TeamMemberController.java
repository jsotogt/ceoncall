package ceoncall.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
  @RequestMapping("/teammembers")
	public List<TeamMember> getAll()
	{
  	return teamMemberService.findAll();
	}
  
  @RequestMapping(value="/teammember", method=RequestMethod.POST)
	public TeamMember create(@RequestBody TeamMember t)
	{
  	teamMemberService.save(t);
  	
  	return t;
	}
  
  @RequestMapping(value="/teammember/{id}", method=RequestMethod.PUT)
	public TeamMember update(@PathVariable("id") int id, @RequestBody TeamMember t)
	{
  	TeamMember tOld = teamMemberService.findById(id);
  	
  	if (tOld == null)
  		return tOld;
  	
  	t.setId(id);
		
  	return teamMemberService.update(t);
	}
  
  @RequestMapping(value="/teammember/{id}", method=RequestMethod.GET)
	public TeamMember get(@PathVariable("id") int id)
	{
  	return teamMemberService.findById(id);
	}
  
  @RequestMapping(value="/teammember/{id}", method=RequestMethod.DELETE)
	public TeamMember delete(@PathVariable("id") int id)
	{
  	TeamMember t = teamMemberService.findById(id);
  	if (t == null)
  		return t;
  	
  	teamMemberService.delete(t);
  	
  	return t;
	}
}
