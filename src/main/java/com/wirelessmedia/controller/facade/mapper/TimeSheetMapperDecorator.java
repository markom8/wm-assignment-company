package com.wirelessmedia.controller.facade.mapper;

import com.wirelessmedia.datatransferobject.TimeSheetDTO;
import com.wirelessmedia.datatransferobject.TimeSheetRecord;
import com.wirelessmedia.datatransferobject.TimeSheetRecordsSum;
import com.wirelessmedia.domainobject.EmployeeDO;
import com.wirelessmedia.domainobject.ProjectDO;
import com.wirelessmedia.domainobject.TaskDO;
import com.wirelessmedia.domainobject.TimeSheetDO;
import com.wirelessmedia.exception.EmplyeeNotAssignedToProject;
import com.wirelessmedia.service.employee.EmployeeService;
import com.wirelessmedia.service.project.ProjectService;
import com.wirelessmedia.service.task.TaskService;
import com.wirelessmedia.service.timesheet.TimeSheetService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class TimeSheetMapperDecorator implements TimeSheetMapper
{
    @Autowired
    private TimeSheetMapper delegate;

    @Autowired
    private TimeSheetService timeSheetService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private ProjectMapper projectMapper;


    @Override public TimeSheetDO mapToTimeSheetDO(TimeSheetDTO timeSheetDTO) throws EmplyeeNotAssignedToProject
    {
        TimeSheetDO timeSheetDO = null;

        Optional<ProjectDO> projectDOOptional = projectService.findProjectByName(timeSheetDTO.getProjectName());
        projectDOOptional.orElseThrow(() -> new EntityNotFoundException("No project found with project name: " + timeSheetDTO.getProjectName()));
        ProjectDO projectDO = projectDOOptional.get();
        Optional<EmployeeDO> employeeDOOptional = employeeService.findEmployeeByPersonalNumber(timeSheetDTO.getEmployeePersonalNumber());
        employeeDOOptional.orElseThrow(() -> new EntityNotFoundException("No employee found with personal id " + timeSheetDTO.getEmployeePersonalNumber()));
        EmployeeDO employeeDO = employeeDOOptional.get();
        Optional<TaskDO> optionalTaskDO = taskService.findTaskByName(timeSheetDTO.getTaskName());
        optionalTaskDO.orElseThrow(()->new EntityNotFoundException("No task found with task name " + timeSheetDTO.getTaskName()));
        TaskDO taskDO = optionalTaskDO.get();

        if (!projectDO.getProjectManager().equals(employeeDO) && !projectDO.getTeamDOS().stream().filter(p -> p.getTeamLead().equals(employeeDO)).findFirst()
            .isPresent() && !projectDO.getTeamDOS().stream().filter(p->p.getDevelopers().contains(employeeDO)).findFirst().isPresent())
        {
            throw new EmplyeeNotAssignedToProject("Employee not assigned to project!");
        }

        Optional<TimeSheetDO> entity = timeSheetService.findTimeSheetByDTO(projectDO,employeeDO,taskDO,timeSheetDTO.getDate());
        if(entity.isPresent()){
            timeSheetDO = entity.get();
            if(timeSheetDTO.getDate()!=null) timeSheetDO.setDate(timeSheetDTO.getDate());
            if(timeSheetDTO.getTeam()!=null) timeSheetDO.setTeam(timeSheetDTO.getTeam());
            if(timeSheetDTO.getWorkedHours()!=null) timeSheetDTO.setWorkedHours(timeSheetDTO.getWorkedHours());
        }else{
            timeSheetDO = delegate.mapToTimeSheetDO(timeSheetDTO);
            timeSheetDO.setProjectDO(projectDO);
            timeSheetDO.setEmployeeDO(employeeDO);
            timeSheetDO.setTaskDO(taskDO);
        }
        return timeSheetService.saveTimeSheet(timeSheetDO);
    }


    @Override public TimeSheetRecord mapToTimeSheetRecord(TimeSheetDO timeSheetDO)
    {
        TimeSheetRecord timeSheetRecord = delegate.mapToTimeSheetRecord(timeSheetDO);
        timeSheetRecord.setEmployeeDTO(employeeMapper.mapToEmployeeDTO(timeSheetDO.getEmployeeDO()));
        timeSheetRecord.setTaskDTO(taskMapper.mapToTaskDTO(timeSheetDO.getTaskDO()));
        timeSheetRecord.setProjectRecord(projectMapper.mapToProjectRecord(timeSheetDO.getProjectDO()));

        return timeSheetRecord;
    }


    @Override public List<TimeSheetRecord> mapToTimeSheetRecords(List<TimeSheetDO> timeSheetDOS)
    {
        return timeSheetDOS.stream().map(timeSheetDO -> mapToTimeSheetRecord(timeSheetDO)).collect(Collectors.toList());
    }


//    @Override public TimeSheetRecordsSum mapToTimeSheetRecordSum(List<TimeSheetDO> timeSheetDOS)
//    {
//        TimeSheetRecordsSum timeSheetRecordsSum = new TimeSheetRecordsSum();
//        timeSheetRecordsSum.setTimeSheetRecords(mapToTimeSheetRecords(timeSheetDOS));
//        timeSheetRecordsSum.setSumOfWorkingHours(timeSheetDOS.stream().reduce(0d, (a, b) -> a + b));
//        return timeSheetRecordsSum;
//    }
}
