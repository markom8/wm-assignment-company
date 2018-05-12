package com.wirelessmedia.service.timesheet;

import com.wirelessmedia.domainobject.EmployeeDO;
import com.wirelessmedia.domainobject.ProjectDO;
import com.wirelessmedia.domainobject.TaskDO;
import com.wirelessmedia.domainobject.TimeSheetDO;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TimeSheetService
{
    Optional<TimeSheetDO> findTimeSheetId(Long id);

    Optional<TimeSheetDO> findTimeSheetByDTO(ProjectDO projectDO, EmployeeDO employeeDO, TaskDO taskDO, Date date);

    TimeSheetDO saveTimeSheet(TimeSheetDO timeSheetDO);

    void deleteTimeSheet(TimeSheetDO timeSheetDO);

    List<TimeSheetDO> getAll();

    List<TimeSheetDO> getTimeSheetsByEmployeeDOAndProjectDO(EmployeeDO employeeDO, ProjectDO projectDO);
}
