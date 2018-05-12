package com.wirelessmedia.controller.facade;

import com.wirelessmedia.datatransferobject.*;
import com.wirelessmedia.exception.EmplyeeMystBeJuniorOrMediorDeveloper;
import com.wirelessmedia.exception.EmplyeeMystBeTeamLead;
import com.wirelessmedia.exception.EmplyeeNotAssignedToProject;

import java.util.List;

public interface TimeSheetFacade
{
    TimeSheetRecord saveTimeSheet(TimeSheetDTO timeSheetDTO) throws EmplyeeNotAssignedToProject;

    List<TimeSheetRecord> getAllTimeSheets();

    TimeSheetRecordsSum getTimeSheetWorkLog(TimeSheetWorkLogDTO timeSheetWorkLogDTO);
}
