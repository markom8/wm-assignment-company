package com.wirelessmedia.controller.api;

import com.wirelessmedia.controller.facade.EmployeeFacade;
import com.wirelessmedia.controller.facade.TeamFacade;
import com.wirelessmedia.datatransferobject.EmployeeDTO;
import com.wirelessmedia.datatransferobject.TeamDTO;
import com.wirelessmedia.datatransferobject.TeamRecord;
import com.wirelessmedia.exception.EmplyeeMystBeJuniorOrMediorDeveloper;
import com.wirelessmedia.exception.EmplyeeMystBeTeamLead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/team")
public class TeamController
{
    private final TeamFacade teamFacade;

    @Autowired
    public TeamController(TeamFacade teamFacade)
    {
        this.teamFacade = teamFacade;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeamRecord createOrUpdateTeam(@Valid @RequestBody TeamDTO teamDTO) throws ConstraintViolationException, EmplyeeMystBeJuniorOrMediorDeveloper, EmplyeeMystBeTeamLead
    {
        return teamFacade.saveTeam(teamDTO);
    }

    @GetMapping("/{teamId}")
    public TeamRecord getTeam(@PathVariable Long teamName) throws EntityNotFoundException
    {
        return teamFacade.getTeamById(teamName);
    }

    @GetMapping
    public List<TeamRecord> getTeams() throws EntityNotFoundException{
        return  teamFacade.getAllTeams();
    }
}
