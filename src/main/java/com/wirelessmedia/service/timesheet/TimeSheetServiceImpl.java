package com.wirelessmedia.service.timesheet;

import com.wirelessmedia.dataaccessobject.TimeSheetRepository;
import com.wirelessmedia.domainobject.EmployeeDO;
import com.wirelessmedia.domainobject.ProjectDO;
import com.wirelessmedia.domainobject.TaskDO;
import com.wirelessmedia.domainobject.TimeSheetDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TimeSheetServiceImpl implements TimeSheetService
{
    private TimeSheetRepository timeSheetRepository;


    @Autowired
    public TimeSheetServiceImpl(TimeSheetRepository timeSheetRepository)
    {
        this.timeSheetRepository = timeSheetRepository;
    }


    @Override public Optional<TimeSheetDO> findTimeSheetId(Long id)
    {
        return timeSheetRepository.findById(id);
    }


    @Override public Optional<TimeSheetDO> findTimeSheetByDTO(
        ProjectDO projectDO, EmployeeDO employeeDO, TaskDO taskDO, Date date)
    {
        return timeSheetRepository.findByProjectDOAndEmployeeDOAndTaskDOAndDate(projectDO, employeeDO, taskDO, date);
    }


    @Override public TimeSheetDO saveTimeSheet(TimeSheetDO timeSheetDO)
    {
        return timeSheetRepository.save(timeSheetDO);
    }


    @Override public void deleteTimeSheet(TimeSheetDO timeSheetDO)
    {
        timeSheetRepository.delete(timeSheetDO);
    }


    @Override public List<TimeSheetDO> getAll()
    {
        return timeSheetRepository.findAll();
    }


    @Override public List<TimeSheetDO> getTimeSheetsByEmployeeDOAndProjectDO(EmployeeDO employeeDO, ProjectDO projectDO)
    {
        return timeSheetRepository.findByProjectDOAndEmployeeDO(projectDO, employeeDO);
    }
}
