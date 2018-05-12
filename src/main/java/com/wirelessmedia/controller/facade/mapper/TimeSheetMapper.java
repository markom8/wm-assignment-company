package com.wirelessmedia.controller.facade.mapper;

import com.wirelessmedia.datatransferobject.*;
import com.wirelessmedia.domainobject.ProjectDO;
import com.wirelessmedia.domainobject.TimeSheetDO;
import com.wirelessmedia.exception.EmplyeeMystBeJuniorOrMediorDeveloper;
import com.wirelessmedia.exception.EmplyeeMystBeTeamLead;
import com.wirelessmedia.exception.EmplyeeNotAssignedToProject;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EmployeeMapper.class, TaskMapper.class, ProjectMapper.class})
@DecoratedWith(TimeSheetMapperDecorator.class)
public interface TimeSheetMapper
{

    @Mapping(target = "timeSheetId", ignore = true)
    TimeSheetDO mapToTimeSheetDO(TimeSheetDTO timeSheetDTO) throws EmplyeeNotAssignedToProject;

    @Mapping(target = "employeeDTO", ignore = true)
    @Mapping(target = "projectRecord", ignore = true)
    @Mapping(target = "taskDTO", ignore = true)
    TimeSheetRecord mapToTimeSheetRecord(TimeSheetDO timeSheetDO);

    List<TimeSheetRecord> mapToTimeSheetRecords(List<TimeSheetDO> timeSheetDOS);
}
