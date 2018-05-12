package com.wirelessmedia.service.task;

import com.wirelessmedia.dataaccessobject.EmployeeRepository;
import com.wirelessmedia.dataaccessobject.TaskRepository;
import com.wirelessmedia.domainobject.EmployeeDO;
import com.wirelessmedia.domainobject.TaskDO;
import com.wirelessmedia.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TaskServiceImpl implements TaskService
{
    private TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository)
    {
        this.taskRepository = taskRepository;
    }


    @Override public Optional<TaskDO> findTaskById(Long id)
    {
        return taskRepository.findById(id);
    }


    @Override public Optional<TaskDO> findTaskByName(String taskName)
    {
        return taskRepository.findByTaskName(taskName);
    }


    @Override public TaskDO saveTask(TaskDO taskDO)
    {
        return taskRepository.save(taskDO);
    }


    @Override public void deleteTask(TaskDO taskDO)
    {
        taskRepository.delete(taskDO);
    }


    @Override public List<TaskDO> getAll()
    {
        return taskRepository.findAll();
    }
}
