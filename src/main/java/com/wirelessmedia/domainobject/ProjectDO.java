package com.wirelessmedia.domainobject;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "project")
public class ProjectDO
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "project_id")
    private Long projectId;

    @Column(name = "project_name")
    @NotNull(message = "Project name can not be null!")
    private String projectName;

    @Column(name = "client_name")
    @NotNull(message = "Client name can not be null!")
    private String clientName;

    @ManyToMany(mappedBy = "projectDOs")
    private Set<TeamDO> teamDOS = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "project_manager", referencedColumnName = "employee_id")
    private EmployeeDO projectManager;


    public ProjectDO()
    {
    }


    public Long getProjectId()
    {
        return projectId;
    }


    public void setProjectId(Long projectId)
    {
        this.projectId = projectId;
    }


    public String getProjectName()
    {
        return projectName;
    }


    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }


    public String getClientName()
    {
        return clientName;
    }


    public void setClientName(String clientName)
    {
        this.clientName = clientName;
    }


    public Set<TeamDO> getTeamDOS()
    {
        return teamDOS;
    }


    public void setTeamDOS(Set<TeamDO> teamDOS)
    {
        this.teamDOS = teamDOS;
    }


    public EmployeeDO getProjectManager()
    {
        return projectManager;
    }


    public void setProjectManager(EmployeeDO projectManager)
    {
        this.projectManager = projectManager;
    }
}
