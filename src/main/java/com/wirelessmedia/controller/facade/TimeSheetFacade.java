package com.wirelessmedia.controller.facade;

import com.wirelessmedia.datatransferobject.ProjectDTO;
import com.wirelessmedia.datatransferobject.ProjectRecord;
import com.wirelessmedia.datatransferobject.TimeSheetDTO;
import com.wirelessmedia.datatransferobject.TimeSheetRecord;
import com.wirelessmedia.exception.EmplyeeMystBeJuniorOrMediorDeveloper;
import com.wirelessmedia.exception.EmplyeeMystBeTeamLead;
import com.wirelessmedia.exception.EmplyeeNotAssignedToProject;

import java.util.List;

public interface TimeSheetFacade
{
    TimeSheetRecord saveTimeSheet(TimeSheetDTO timeSheetDTO) throws EmplyeeNotAssignedToProject;

    List<TimeSheetRecord> getAllTimeSheets();
}
