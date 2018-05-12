package com.wirelessmedia.datatransferobject;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

public class TimeSheetRecord implements Serializable
{

    private static final long serialVersionUID = -3771916621334625868L;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private ZonedDateTime date;

    private Float workedHours;

    private String team;

    private TaskDTO taskDTO;

    private EmployeeDTO employeeDTO;

    private ProjectRecord projectRecord;


    public TimeSheetRecord()
    {
    }


    public ZonedDateTime getDate()
    {
        return date;
    }


    public void setDate(ZonedDateTime date)
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


    public TaskDTO getTaskDTO()
    {
        return taskDTO;
    }


    public void setTaskDTO(TaskDTO taskDTO)
    {
        this.taskDTO = taskDTO;
    }


    public EmployeeDTO getEmployeeDTO()
    {
        return employeeDTO;
    }


    public void setEmployeeDTO(EmployeeDTO employeeDTO)
    {
        this.employeeDTO = employeeDTO;
    }


    public ProjectRecord getProjectRecord()
    {
        return projectRecord;
    }


    public void setProjectRecord(ProjectRecord projectRecord)
    {
        this.projectRecord = projectRecord;
    }
}
