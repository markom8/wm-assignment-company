package com.wirelessmedia.domainobject;

import com.wirelessmedia.domainvalue.TimeSheetPK;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@Table(name = "time_sheet")
public class TimeSheetDO
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "time_sheet_id")
    private Long timeSheetId;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "Date can't be null!")
    private Date date;

    @Column
    private Float workedHours;

    @Column
    private String team;

    @ManyToOne
    @JoinColumn(name = "task_id", referencedColumnName = "task_id")
    @NotNull(message = "Task can't be null!")
    private TaskDO taskDO;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    @NotNull(message = "Employee can't be null!")
    private EmployeeDO employeeDO;

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    @NotNull(message = "Project can't be null!")
    private ProjectDO projectDO;

    public TimeSheetDO()
    {
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


    public TaskDO getTaskDO()
    {
        return taskDO;
    }


    public void setTaskDO(TaskDO taskDO)
    {
        this.taskDO = taskDO;
    }


    public Long getTimeSheetId()
    {
        return timeSheetId;
    }


    public void setTimeSheetId(Long timeSheetId)
    {
        this.timeSheetId = timeSheetId;
    }


    public EmployeeDO getEmployeeDO()
    {
        return employeeDO;
    }


    public void setEmployeeDO(EmployeeDO employeeDO)
    {
        this.employeeDO = employeeDO;
    }


    public ProjectDO getProjectDO()
    {
        return projectDO;
    }


    public void setProjectDO(ProjectDO projectDO)
    {
        this.projectDO = projectDO;
    }
}
