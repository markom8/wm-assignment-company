package com.wirelessmedia.service.employee;

import com.wirelessmedia.dataaccessobject.EmployeeRepository;
import com.wirelessmedia.domainobject.EmployeeDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService
{
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }


    @Override public Optional<EmployeeDO> findEmployeeById(Long id)
    {
        return employeeRepository.findById(id);
    }


    @Override public Optional<EmployeeDO> findEmployeeByPersonalNumber(String personalNumber)
    {
        return employeeRepository.findByPersonalNumber(personalNumber);
    }


    @Override public EmployeeDO saveEmployee(EmployeeDO employeeDO)
    {
        return employeeRepository.save(employeeDO);
    }


    @Override public void deleteEmployee(EmployeeDO employeeDO)
    {
        employeeRepository.delete(employeeDO);
    }


    @Override public List<EmployeeDO> getAll()
    {
        return employeeRepository.findAll();
    }
}
