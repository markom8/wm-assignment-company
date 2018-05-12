package com.wirelessmedia.datatransferobject;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ProjectDTO implements Serializable
{

    private static final long serialVersionUID = -6362129123869958957L;

    @NotNull(message = "error.project.projectName.null")
    private String projectName;

    private String clientName;

    private String teamName;

    private String projectManagerPersonalNumber;


    public ProjectDTO()
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


    public String getTeamName()
    {
        return teamName;
    }


    public void setTeamName(String teamName)
    {
        this.teamName = teamName;
    }


    public String getProjectManagerPersonalNumber()
    {
        return projectManagerPersonalNumber;
    }


    public void setProjectManagerPersonalNumber(String projectManagerPersonalNumber)
    {
        this.projectManagerPersonalNumber = projectManagerPersonalNumber;
    }
}
