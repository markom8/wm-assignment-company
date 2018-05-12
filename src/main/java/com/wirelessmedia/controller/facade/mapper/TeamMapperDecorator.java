package com.wirelessmedia.controller.facade.mapper;

import com.wirelessmedia.datatransferobject.TeamDTO;
import com.wirelessmedia.domainobject.EmployeeDO;
import com.wirelessmedia.domainobject.TeamDO;
import com.wirelessmedia.domainvalue.EmployeeType;
import com.wirelessmedia.exception.EmplyeeMystBeJuniorOrMediorDeveloper;
import com.wirelessmedia.exception.EmplyeeMystBeTeamLead;
import com.wirelessmedia.service.employee.EmployeeService;
import com.wirelessmedia.service.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

public abstract class TeamMapperDecorator implements TeamMapper
{
    @Autowired
    private TeamMapper delegate;

    @Autowired
    private TeamService teamService;

    @Autowired
    private EmployeeService employeeService;


    @Override public TeamDO mapToTeamDO(TeamDTO teamDTO) throws EmplyeeMystBeJuniorOrMediorDeveloper, EmplyeeMystBeTeamLead
    {
        TeamDO teamDO = null;
        Optional<TeamDO> entity = teamService.findTeamByName(teamDTO.getTeamName());

        if(entity.isPresent()){
            teamDO = entity.get();
        }else{
            teamDO = teamService.saveTeam(delegate.mapToTeamDO(teamDTO));
        }
        if(teamDTO.getDeveloperPersonalNumber()!=null)
        {
            Optional<EmployeeDO> employeeDO = employeeService.findEmployeeByPersonalNumber(teamDTO.getDeveloperPersonalNumber());
            employeeDO.orElseThrow(() -> new EntityNotFoundException("No employee found with personal id " + teamDTO.getDeveloperPersonalNumber()));
            if(!employeeDO.get().getEmployeeType().equals(EmployeeType.JUNIOR_DEVELOPER)&& !employeeDO.get().getEmployeeType().equals(EmployeeType.SENIOR_DEVELOPER))
            {
                throw new EmplyeeMystBeJuniorOrMediorDeveloper("Employee must be a junior or senior developer!");
            }
            employeeDO.get().getTeamDO().add(teamDO);
            employeeService.saveEmployee(employeeDO.get());
            teamDO.getDevelopers().add(employeeDO.get());

        }
        if(teamDTO.getTeamLeadPersonalNumber()!=null){
            Optional<EmployeeDO> employeeDO = employeeService.findEmployeeByPersonalNumber(teamDTO.getTeamLeadPersonalNumber());
            employeeDO.orElseThrow(() -> new EntityNotFoundException("No employee found with personal id " + teamDTO.getDeveloperPersonalNumber()));
            if(!employeeDO.get().getEmployeeType().equals(EmployeeType.TEAM_LEAD)){
                throw new EmplyeeMystBeTeamLead("Employee must be a team lead!");
            }
            teamDO.setTeamLead(employeeDO.get());
        }

        return teamService.saveTeam(teamDO);
    }
}
