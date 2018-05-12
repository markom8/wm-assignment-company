package com.wirelessmedia.datatransferobject;

import com.wirelessmedia.domainvalue.EmployeeType;

import java.io.Serializable;

public class EmployeeDTO implements Serializable
{

    private static final long serialVersionUID = -1125740123029335869L;

    private String firstName;

    private String lastName;

    private String personalNumber;

    private EmployeeType employeeType;


    public EmployeeDTO()
    {

    }


    public String getFirstName()
    {
        return firstName;
    }


    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }


    public String getLastName()
    {
        return lastName;
    }


    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }


    public String getPersonalNumber()
    {
        return personalNumber;
    }


    public void setPersonalNumber(String personalNumber)
    {
        this.personalNumber = personalNumber;
    }


    public EmployeeType getEmployeeType()
    {
        return employeeType;
    }


    public void setEmployeeType(EmployeeType employeeType)
    {
        this.employeeType = employeeType;
    }
}
