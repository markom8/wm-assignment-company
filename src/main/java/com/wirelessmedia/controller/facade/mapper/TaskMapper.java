package com.wirelessmedia.controller.facade.mapper;

import com.wirelessmedia.datatransferobject.EmployeeDTO;
import com.wirelessmedia.datatransferobject.TaskDTO;
import com.wirelessmedia.domainobject.EmployeeDO;
import com.wirelessmedia.domainobject.TaskDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper
{
    @Mapping(target = "taskId", ignore = true)
    TaskDO mapToTaskDO(TaskDTO taskDTO);

    TaskDTO mapToTaskDTO(TaskDO taskDO);

    List<TaskDTO> mapToTaskDTOs(List<TaskDO> taskDOS);
}
