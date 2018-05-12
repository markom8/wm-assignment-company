package com.wirelessmedia.controller.facade;

import com.wirelessmedia.controller.facade.mapper.TeamMapper;
import com.wirelessmedia.controller.facade.mapper.TimeSheetMapper;
import com.wirelessmedia.datatransferobject.*;
import com.wirelessmedia.domainobject.TimeSheetDO;
import com.wirelessmedia.exception.EmplyeeMystBeJuniorOrMediorDeveloper;
import com.wirelessmedia.exception.EmplyeeMystBeTeamLead;
import com.wirelessmedia.exception.EmplyeeNotAssignedToProject;
import com.wirelessmedia.service.employee.EmployeeService;
import com.wirelessmedia.service.project.ProjectService;
import com.wirelessmedia.service.team.TeamService;
import com.wirelessmedia.service.timesheet.TimeSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class TimeSheetFacadeImpl implements TimeSheetFacade
{
    private final TimeSheetService timeSheetService;

    private final EmployeeService employeeService;

    private final ProjectService projectService;

    private final TimeSheetMapper timeSheetMapper;

    @Autowired
    public TimeSheetFacadeImpl(TimeSheetService timeSheetService, TimeSheetMapper timeSheetMapper, EmployeeService employeeService, ProjectService projectService)
    {
        this.timeSheetService = timeSheetService;
        this.timeSheetMapper = timeSheetMapper;
        this.employeeService = employeeService;
        this.projectService = projectService;
    }

    @Override public TimeSheetRecord saveTimeSheet(TimeSheetDTO timeSheetDTO) throws EmplyeeNotAssignedToProject
    {

        return timeSheetMapper.mapToTimeSheetRecord(timeSheetService.saveTimeSheet(timeSheetMapper.mapToTimeSheetDO(timeSheetDTO)));
    }


    @Override public List<TimeSheetRecord> getAllTimeSheets()
    {
        return timeSheetMapper.mapToTimeSheetRecords(timeSheetService.getAll());
    }


    @Override public TimeSheetRecordsSum getTimeSheetWorkLog(TimeSheetWorkLogDTO timeSheetWorkLogDTO)
    {
        TimeSheetRecordsSum timeSheetRecordsSum = new TimeSheetRecordsSum();
        List<TimeSheetDO> timeSheetDOS =  timeSheetService.getTimeSheetsByEmployeeDOAndProjectDO(employeeService.findEmployeeByPersonalNumber(timeSheetWorkLogDTO.getEmployeePersonalNumber()).get(), projectService.findProjectByName(timeSheetWorkLogDTO.getProjectName()).get());
        timeSheetRecordsSum.setTimeSheetRecords(timeSheetMapper.mapToTimeSheetRecords(timeSheetDOS));
        timeSheetRecordsSum.setSumOfWorkingHours(timeSheetDOS.stream().mapToDouble(t-> t.getWorkedHours()).sum());
        return timeSheetRecordsSum;

    }
}
