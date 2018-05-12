package com.wirelessmedia.datatransferobject;

import com.wirelessmedia.domainobject.EmployeeDO;
import com.wirelessmedia.domainvalue.EmployeeType;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

public class TeamDTO implements Serializable
{

    private static final long serialVersionUID = -1046741458648106914L;

    @NotNull(message = "error.team.teamName.null")
    private String teamName;

    private String developerPersonalNumber;

    private String teamLeadPersonalNumber;


    public TeamDTO()
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


    public String getDeveloperPersonalNumber()
    {
        return developerPersonalNumber;
    }


    public void setDeveloperPersonalNumber(String developerPersonalNumber)
    {
        this.developerPersonalNumber = developerPersonalNumber;
    }


    public String getTeamLeadPersonalNumber()
    {
        return teamLeadPersonalNumber;
    }


    public void setTeamLeadPersonalNumber(String teamLeadPersonalNumber)
    {
        this.teamLeadPersonalNumber = teamLeadPersonalNumber;
    }
}
