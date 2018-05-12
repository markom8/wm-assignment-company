package com.wirelessmedia.service.employee;

import com.wirelessmedia.domainobject.EmployeeDO;
import com.wirelessmedia.domainvalue.EmployeeType;

import java.util.List;
import java.util.Optional;

public interface EmployeeService
{
    Optional<EmployeeDO> findEmployeeById(Long id);

    Optional<EmployeeDO> findEmployeeByPersonalNumber(String teamName);

    EmployeeDO saveEmployee(EmployeeDO employeeDO);

    void deleteEmployee(EmployeeDO employeeDO);

    List<EmployeeDO> getAll();
}
