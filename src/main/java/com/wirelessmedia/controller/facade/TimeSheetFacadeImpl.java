package com.wirelessmedia.controller.facade;

import com.wirelessmedia.controller.facade.mapper.TeamMapper;
import com.wirelessmedia.controller.facade.mapper.TimeSheetMapper;
import com.wirelessmedia.datatransferobject.TeamDTO;
import com.wirelessmedia.datatransferobject.TeamRecord;
import com.wirelessmedia.datatransferobject.TimeSheetDTO;
import com.wirelessmedia.datatransferobject.TimeSheetRecord;
import com.wirelessmedia.exception.EmplyeeMystBeJuniorOrMediorDeveloper;
import com.wirelessmedia.exception.EmplyeeMystBeTeamLead;
import com.wirelessmedia.exception.EmplyeeNotAssignedToProject;
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

    private final TimeSheetMapper timeSheetMapper;

    @Autowired
    public TimeSheetFacadeImpl(TimeSheetService timeSheetService, TimeSheetMapper timeSheetMapper)
    {
        this.timeSheetService = timeSheetService;
        this.timeSheetMapper = timeSheetMapper;
    }

    @Override public TimeSheetRecord saveTimeSheet(TimeSheetDTO timeSheetDTO) throws EmplyeeNotAssignedToProject
    {

        return timeSheetMapper.mapToTimeSheetRecord(timeSheetService.saveTimeSheet(timeSheetMapper.mapToTimeSheetDO(timeSheetDTO)));
    }


    @Override public List<TimeSheetRecord> getAllTimeSheets()
    {
        return timeSheetMapper.mapToTimeSheetRecords(timeSheetService.getAll());
    }
}
