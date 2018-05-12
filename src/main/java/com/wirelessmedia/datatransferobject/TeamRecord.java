package com.wirelessmedia.datatransferobject;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wirelessmedia.domainobject.EmployeeDO;

import java.io.Serializable;
import java.util.Set;

public class TeamRecord implements Serializable
{

    private static final long serialVersionUID = 4810087416110522463L;

    private String teamName;

    private Set<EmployeeDTO> developers;

    private EmployeeDTO teamLead;


    public TeamRecord()
    {
    }


    public String getTeamName()
    {
        return teamName;
    }


    public void setTeamName(String teamName)
    {
        this.teamName = teamName;
    }


    public Set<EmployeeDTO> getDevelopers()
    {
        return developers;
    }


    public void setDevelopers(Set<EmployeeDTO> developers)
    {
        this.developers = developers;
    }


    public EmployeeDTO getTeamLead()
    {
        return teamLead;
    }


    public void setTeamLead(EmployeeDTO teamLead)
    {
        this.teamLead = teamLead;
    }
}
