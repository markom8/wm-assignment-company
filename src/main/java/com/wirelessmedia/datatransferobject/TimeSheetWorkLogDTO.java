package com.wirelessmedia.datatransferobject;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class TimeSheetWorkLogDTO implements Serializable
{

    private static final long serialVersionUID = 6015866745549180479L;

    @NotNull(message = "error.timesheet.projectName.null")
    private String projectName;

    @NotNull(message = "error.timesheet.employeePersonalNumber.null")
    private String employeePersonalNumber;

    public TimeSheetWorkLogDTO()
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
}
