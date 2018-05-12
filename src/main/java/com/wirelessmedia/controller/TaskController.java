package com.wirelessmedia.controller;

import com.wirelessmedia.controller.facade.EmployeeFacade;
import com.wirelessmedia.controller.facade.TaskFacade;
import com.wirelessmedia.datatransferobject.EmployeeDTO;
import com.wirelessmedia.datatransferobject.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/task")
public class TaskController
{
    private final TaskFacade taskFacade;

    @Autowired
    public TaskController(TaskFacade taskFacade)
    {
        this.taskFacade = taskFacade;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDTO createTask(@Valid @RequestBody TaskDTO taskDTO) throws ConstraintViolationException
    {
        return taskFacade.saveTask(taskDTO);
    }

    @GetMapping("/{taskName}")
    public TaskDTO getTask(@PathVariable String taskName) throws EntityNotFoundException
    {
        return taskFacade.getTaskByName(taskName);
    }

    @GetMapping
    public List<TaskDTO> getTeams() throws EntityNotFoundException{
        return  taskFacade.getAllTasks();
    }
}
