package ceoncall.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class TeamMember
{
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String phone;
	private String email;
	@ManyToMany(mappedBy = "teamMemberList")
	private List<Schedule> scheduleList;
	
	public TeamMember() {}
	
	public TeamMember(String name, String phone, String email)
	{
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}

	public List<Schedule> getScheduleList() {
		return scheduleList;
	}

	public void setScheduleList(List<Schedule> scheduleList) {
		this.scheduleList = scheduleList;
	}
}
