package com.wirelessmedia.controller.facade;

import com.wirelessmedia.datatransferobject.EmployeeDTO;

import java.util.List;

public interface EmployeeFacade
{
    EmployeeDTO getEmployeeById(Long employeeId);

    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) ;

    EmployeeDTO getEmployeeByPersonalNumber(String personalNumber);

    List<EmployeeDTO> getAllEmployees();
}
