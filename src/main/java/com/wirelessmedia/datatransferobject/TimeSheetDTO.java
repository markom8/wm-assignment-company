package com.wirelessmedia.datatransferobject;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Date;

public class TimeSheetDTO implements Serializable
{

    private static final long serialVersionUID = -9063134278259253512L;

    @NotNull(message = "error.timesheet.projectName.null")
    private String projectName;

    @NotNull(message = "error.timesheet.employeePersonalNumber.null")
    private String employeePersonalNumber;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull(message = "error.timesheet.date.null")
    private Date date;

    private Float workedHours;

    private String team;

    @NotNull(message = "error.timesheet.taskName.null")
    private String taskName;

    public TimeSheetDTO()
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


    public String getEmployeePersonalNumber()
    {
        return employeePersonalNumber;
    }


    public void setEmployeePersonalNumber(String employeePersonalNumber)
    {
        this.employeePersonalNumber = employeePersonalNumber;
    }


    public Date getDate()
    {
        return date;
    }


    public void setDate(Date date)
    {
        this.date = date;
    }


    public Float getWorkedHours()
    {
        return workedHours;
    }


    public void setWorkedHours(Float workedHours)
    {
        this.workedHours = workedHours;
    }


    public String getTeam()
    {
        return team;
    }


    public void setTeam(String team)
    {
        this.team = team;
    }


    public String getTaskName()
    {
        return taskName;
    }


    public void setTaskName(String taskName)
    {
        this.taskName = taskName;
    }
}
