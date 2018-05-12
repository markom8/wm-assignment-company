package com.wirelessmedia.domainobject;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "team")
public class TeamDO
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "team_id")
    private Long teamId;

    @Column(name = "team_name", unique = true)
    @NotNull(message = "Team name can not be null!")
    private String teamName;

    @ManyToMany(mappedBy = "teamDO")
    private Set<EmployeeDO> developers = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "team_lead", referencedColumnName = "employee_id")
    @Where(clause = "employeeType = 'TEAM_LEAD'")
    private EmployeeDO teamLead;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "team_project",
        joinColumns = { @JoinColumn(name = "team_id") },
        inverseJoinColumns = { @JoinColumn(name = "project_id") }
    )
    private Set<ProjectDO> projectDOs = new HashSet<>();

    public TeamDO()
    {
    }


    public Long getTeamId()
    {
        return teamId;
    }


    public void setTeamId(Long teamId)
    {
        this.teamId = teamId;
    }


    public String getTeamName()
    {
        return teamName;
    }


    public void setTeamName(String teamName)
    {
        this.teamName = teamName;
    }


    public EmployeeDO getTeamLead()
    {
        return teamLead;
    }


    public void setTeamLead(EmployeeDO teamLead)
    {
        this.teamLead = teamLead;
    }


    public Set<EmployeeDO> getDevelopers()
    {
        return developers;
    }


    public void setDevelopers(Set<EmployeeDO> developers)
    {
        this.developers = developers;
    }


    public Set<ProjectDO> getProjectDOs()
    {
        return projectDOs;
    }


    public void setProjectDOs(Set<ProjectDO> projectDOs)
    {
        this.projectDOs = projectDOs;
    }
}
