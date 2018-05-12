package com.wirelessmedia.controller.facade;

import com.wirelessmedia.controller.facade.mapper.EmployeeMapper;
import com.wirelessmedia.controller.facade.mapper.TaskMapper;
import com.wirelessmedia.datatransferobject.EmployeeDTO;
import com.wirelessmedia.datatransferobject.TaskDTO;
import com.wirelessmedia.service.employee.EmployeeService;
import com.wirelessmedia.service.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class TaskFacadeImpl implements TaskFacade
{
    private final TaskService taskService;

    private final TaskMapper taskMapper;

    @Autowired
    public TaskFacadeImpl(TaskService taskService, TaskMapper taskMapper)
    {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }


    @Override public TaskDTO getTaskById(Long taskId)
    {
        return taskMapper.mapToTaskDTO(taskService.findTaskById(taskId).get());
    }


    @Override public TaskDTO saveTask(TaskDTO taskDTO)
    {
        return taskMapper.mapToTaskDTO(taskService.saveTask(taskMapper.mapToTaskDO(taskDTO)));
    }


    @Override public TaskDTO getTaskByName(String taskName)
    {
        return taskMapper.mapToTaskDTO(taskService.findTaskByName(taskName).get());
    }


    @Override public List<TaskDTO> getAllTasks()
    {
        return taskMapper.mapToTaskDTOs(taskService.getAll());
    }
}
