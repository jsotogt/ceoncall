package ceoncall.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Schedule {

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

    @OneToMany
    @JoinTable
    private List<CaseNote> caseNoteList;

    public Schedule() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<TeamMember> getTeamMemberList() {
        return teamMemberList;
    }

    public void setTeamMemberList(List<TeamMember> teamMemberList) {
        this.teamMemberList = teamMemberList;
    }

    public List<CaseNote> getCaseNoteList() {
        return caseNoteList;
    }

    public void setCaseNoteList(List<CaseNote> caseNoteList) {
        this.caseNoteList = caseNoteList;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
