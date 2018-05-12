package com.wirelessmedia.controller.facade;

import com.wirelessmedia.datatransferobject.EmployeeDTO;
import com.wirelessmedia.datatransferobject.TeamDTO;
import com.wirelessmedia.datatransferobject.TeamRecord;
import com.wirelessmedia.exception.EmplyeeMystBeJuniorOrMediorDeveloper;
import com.wirelessmedia.exception.EmplyeeMystBeTeamLead;

import java.util.List;

public interface TeamFacade
{
    TeamRecord getTeamById(Long teamId);

    TeamRecord saveTeam(TeamDTO teamDTO) throws EmplyeeMystBeTeamLead, EmplyeeMystBeJuniorOrMediorDeveloper;

    List<TeamRecord> getAllTeams();
}
