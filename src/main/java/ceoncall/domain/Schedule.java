package ceoncall.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(
		name = "Schedule.findByDepartmentID",
		query = "SELECT s FROM Schedule s WHERE s.department = :department AND s.startDate >= :startDate AND s.endDate <= :endDate") })
public class Schedule
{

	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne
	private Department department;
	@ManyToOne
	private Team team;
	@ManyToMany
	@JoinTable
	private List<TeamMember> teamMemberList;
	private Date startDate;
	private Date endDate;

	public Schedule()
	{

	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Department getDepartment()
	{
		return department;
	}

	public void setDepartment(Department department)
	{
		this.department = department;
	}

	public Team getTeam()
	{
		return team;
	}

	public void setTeam(Team team)
	{
		this.team = team;
	}

	public List<TeamMember> getTeamMemberList()
	{
		return teamMemberList;
	}

	public void setTeamMemberList(List<TeamMember> teamMemberList)
	{
		this.teamMemberList = teamMemberList;
	}

	public Date getStartDate()
	{
		return startDate;
	}

	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}

	public Date getEndDate()
	{
		return endDate;
	}

	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}
}
