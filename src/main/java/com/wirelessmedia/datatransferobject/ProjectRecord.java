package com.wirelessmedia.datatransferobject;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class ProjectRecord implements Serializable
{

    private static final long serialVersionUID = 3683173740772349996L;

    private String projectName;

    private String clientName;

    private List<TeamRecord> teamRecords;

    private EmployeeDTO projectManager;


    public ProjectRecord()
    {
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


    public List<TeamRecord> getTeamRecords()
    {
        return teamRecords;
    }


    public void setTeamRecords(List<TeamRecord> teamRecords)
    {
        this.teamRecords = teamRecords;
    }


    public EmployeeDTO getProjectManager()
    {
        return projectManager;
    }


    public void setProjectManager(EmployeeDTO projectManager)
    {
        this.projectManager = projectManager;
    }
}
