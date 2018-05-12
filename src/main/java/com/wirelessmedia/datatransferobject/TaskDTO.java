package com.wirelessmedia.datatransferobject;

import com.wirelessmedia.domainvalue.EmployeeType;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class TaskDTO implements Serializable
{

    private static final long serialVersionUID = -2973331417570873020L;

    @NotNull(message = "error.task.taskName.null")
    private String taskName;

    private String taskDescription;

    public TaskDTO()
    {

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
