package com.wirelessmedia.controller.facade;

import com.wirelessmedia.controller.facade.mapper.EmployeeMapper;
import com.wirelessmedia.controller.facade.mapper.TeamMapper;
import com.wirelessmedia.datatransferobject.EmployeeDTO;
import com.wirelessmedia.datatransferobject.TeamDTO;
import com.wirelessmedia.datatransferobject.TeamRecord;
import com.wirelessmedia.exception.EmplyeeMystBeJuniorOrMediorDeveloper;
import com.wirelessmedia.exception.EmplyeeMystBeTeamLead;
import com.wirelessmedia.service.employee.EmployeeService;
import com.wirelessmedia.service.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class TeamFacadeImpl implements TeamFacade
{
    private final TeamService teamService;

    private final TeamMapper teamMapper;

    @Autowired
    public TeamFacadeImpl(TeamService teamService, TeamMapper teamMapper)
    {
        this.teamService = teamService;
        this.teamMapper = teamMapper;
    }


    @Override public TeamRecord getTeamById(Long teamId)
    {
        return teamMapper.mapToTeamRecord(teamService.findTeamById(teamId).get());
    }


    @Override public TeamRecord saveTeam(TeamDTO teamDTO) throws EmplyeeMystBeTeamLead, EmplyeeMystBeJuniorOrMediorDeveloper
    {
        return teamMapper.mapToTeamRecord(teamService.saveTeam(teamMapper.mapToTeamDO(teamDTO)));
    }


    @Override public List<TeamRecord> getAllTeams()
    {
        return teamMapper.mapToTeamRecords(teamService.getAll());
    }
}
