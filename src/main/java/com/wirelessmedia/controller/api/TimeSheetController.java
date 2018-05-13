package com.wirelessmedia.controller.api;

import com.wirelessmedia.controller.facade.ProjectFacade;
import com.wirelessmedia.controller.facade.TimeSheetFacade;
import com.wirelessmedia.datatransferobject.*;
import com.wirelessmedia.domainobject.TimeSheetDO;
import com.wirelessmedia.exception.EmplyeeMystBeJuniorOrMediorDeveloper;
import com.wirelessmedia.exception.EmplyeeMystBeTeamLead;
import com.wirelessmedia.exception.EmplyeeNotAssignedToProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/timesheet")
public class TimeSheetController
{
    private final TimeSheetFacade timeSheetFacade;

    @Autowired
    public TimeSheetController(TimeSheetFacade timeSheetFacade)
    {
        this.timeSheetFacade = timeSheetFacade;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TimeSheetRecord createOrUpdateTimeSheet(@Valid @RequestBody TimeSheetDTO timeSheetDTO) throws ConstraintViolationException, EmplyeeNotAssignedToProject
    {
        return timeSheetFacade.saveTimeSheet(timeSheetDTO);
    }

    @GetMapping
    public List<TimeSheetRecord> getTimeSheets() throws EntityNotFoundException{
        return  timeSheetFacade.getAllTimeSheets();
    }

    @PostMapping("/worklog")
    @ResponseStatus(HttpStatus.CREATED)
    public TimeSheetRecordsSum getTimeSheetWorkLog(@Valid @RequestBody TimeSheetWorkLogDTO timeSheetWorkLogDTO)
    {
        return timeSheetFacade.getTimeSheetWorkLog(timeSheetWorkLogDTO);
    }
}
