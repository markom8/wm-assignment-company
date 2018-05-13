package com.wirelessmedia.controller.api;

import com.wirelessmedia.controller.facade.EmployeeFacade;
import com.wirelessmedia.datatransferobject.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/employee")
public class EmployeeController
{
    private final EmployeeFacade employeeFacade;

    @Autowired
    public EmployeeController(EmployeeFacade employeeFacade)
    {
        this.employeeFacade = employeeFacade;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDTO createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) throws ConstraintViolationException
    {
        return employeeFacade.saveEmployee(employeeDTO);
    }

    @GetMapping("/{personalNumber}")
    public EmployeeDTO getEmployee(@PathVariable String personalNumber) throws EntityNotFoundException
    {
        return employeeFacade.getEmployeeByPersonalNumber(personalNumber);
    }

    @GetMapping
    public List<EmployeeDTO> getTeams() throws EntityNotFoundException{
        return  employeeFacade.getAllEmployees();
    }
}
