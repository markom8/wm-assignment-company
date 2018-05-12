package com.wirelessmedia.domainobject;

import com.wirelessmedia.domainvalue.EmployeeType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "task")
public class TaskDO
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "task_id")
    private Long taskId;

    @Column(name = "task_name")
    @NotNull(message = "Task name can not be null!")
    private String taskName;

    @Column(name = "task_description")
    private String taskDescription;

    public TaskDO()
    {
    }

    public Long getTaskId()
    {
        return taskId;
    }


    public void setTaskId(Long taskId)
    {
        this.taskId = taskId;
    }


    public String getTaskName()
    {
        return taskName;
    }


    public void setTaskName(String taskName)
    {
        this.taskName = taskName;
    }


    public String getTaskDescription()
    {
        return taskDescription;
    }


    public void setTaskDescription(String taskDescription)
    {
        this.taskDescription = taskDescription;
    }
}
