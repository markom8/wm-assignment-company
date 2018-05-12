package com.wirelessmedia.domainvalue;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class TimeSheetPK implements Serializable
{

    private static final long serialVersionUID = 7061562755051549656L;

    @Column(name="employee_id", nullable = false)
    private Long employeeId;

    @Column(name="project_id", nullable = false)
    private Long projectId;


    public TimeSheetPK()
    {
    }

    public TimeSheetPK(Long employeeId, Long projectId)
    {
        this.employeeId = employeeId;
        this.projectId = projectId;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (obj == this)
        {
            return true;
        }
        if (obj.getClass() != getClass())
        {
            return false;
        }
        TimeSheetPK rhs = (TimeSheetPK) obj;
        return new EqualsBuilder()
            .append(this.employeeId, rhs.employeeId)
            .append(this.projectId, rhs.projectId)
            .isEquals();
    }


    @Override
    public int hashCode()
    {
        return new HashCodeBuilder()
            .append(employeeId)
            .append(projectId)
            .toHashCode();
    }
}
