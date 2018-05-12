package com.wirelessmedia.controller.facade.mapper;

import com.wirelessmedia.datatransferobject.EmployeeDTO;
import com.wirelessmedia.domainobject.EmployeeDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface EmployeeMapper
{
    @Mapping(target = "employeeId", ignore = true)
    EmployeeDO mapToEmployeeDO(EmployeeDTO employeeDTO);

    EmployeeDTO mapToEmployeeDTO(EmployeeDO employeeDO);

    List<EmployeeDTO> mapToEmployeeDTOs(List<EmployeeDO> employeeDO);
}
