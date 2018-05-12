package com.wirelessmedia.domainobject;

import com.wirelessmedia.domainvalue.EmployeeType;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee")
public class EmployeeDO
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "first_name")
    @NotNull(message = "First name can not be null!")
    private String firstName;

    @Column(name = "last_name")
    @NotNull(message = "Last Name can not be null!")
    private String lastName;

    @Column(name = "personal_number", unique = true)
    @NotNull(message = "Personal number can not be null!")
    private String personalNumber;

    @Column(name = "employee_type", nullable = false, length = 250)
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Engine type can not be null!")
    private EmployeeType employeeType;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "employee_team",
        joinColumns = { @JoinColumn(name = "employee_id") },
        inverseJoinColumns = { @JoinColumn(name = "team_id") }
    )
    private Set<TeamDO> teamDO = new HashSet<>();

    public EmployeeDO()
    {
    }


    public Long getEmployeeId()
    {
        return employeeId;
    }


    public void setEmployeeId(Long employeeId)
    {
        this.employeeId = employeeId;
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


    public Set<TeamDO> getTeamDO()
    {
        return teamDO;
    }


    public void setTeamDO(Set<TeamDO> teamDO)
    {
        this.teamDO = teamDO;
    }
}
