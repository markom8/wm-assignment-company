package com.wirelessmedia.service.task;

import com.wirelessmedia.domainobject.EmployeeDO;
import com.wirelessmedia.domainobject.TaskDO;

import java.util.List;
import java.util.Optional;

public interface TaskService
{
    Optional<TaskDO> findTaskById(Long id);

    Optional<TaskDO> findTaskByName(String taskName);

    TaskDO saveTask(TaskDO taskDO);

    void deleteTask(TaskDO taskDO);

    List<TaskDO> getAll();
}
