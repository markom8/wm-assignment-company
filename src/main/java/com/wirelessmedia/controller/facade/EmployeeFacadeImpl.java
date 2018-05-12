package com.wirelessmedia.controller.facade;

import com.wirelessmedia.controller.facade.mapper.EmployeeMapper;
import com.wirelessmedia.datatransferobject.EmployeeDTO;
import com.wirelessmedia.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class EmployeeFacadeImpl implements EmployeeFacade
{
    private final EmployeeService employeeService;

    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeFacadeImpl(EmployeeService employeeService, EmployeeMapper employeeMapper)
    {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
    }


    @Override public EmployeeDTO getEmployeeById(Long employeeId)
    {
        return employeeMapper.mapToEmployeeDTO(employeeService.findEmployeeById(employeeId).get());
    }


    @Override public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO)
    {
        return employeeMapper.mapToEmployeeDTO(employeeService.saveEmployee(employeeMapper.mapToEmployeeDO(employeeDTO)));
    }


    @Override public EmployeeDTO getEmployeeByPersonalNumber(String personalNumber)
    {
        return employeeMapper.mapToEmployeeDTO(employeeService.findEmployeeByPersonalNumber(personalNumber).get());
    }


    @Override public List<EmployeeDTO> getAllEmployees()
    {
        return employeeMapper.mapToEmployeeDTOs(employeeService.getAll());
    }
}
