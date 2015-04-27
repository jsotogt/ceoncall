package ceoncall.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TeamMember
{
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String phone;
	private String email;
	
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
	
	
}