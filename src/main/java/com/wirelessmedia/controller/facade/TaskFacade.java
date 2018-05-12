package com.wirelessmedia.controller.facade;

import com.wirelessmedia.datatransferobject.EmployeeDTO;
import com.wirelessmedia.datatransferobject.TaskDTO;

import java.util.List;

public interface TaskFacade
{
    TaskDTO getTaskById(Long taskId);

    TaskDTO saveTask(TaskDTO taskDTO) ;

    TaskDTO getTaskByName(String taskName);

    List<TaskDTO> getAllTasks();
}
