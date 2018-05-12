package com.wirelessmedia.controller.facade.mapper;

import com.wirelessmedia.datatransferobject.ProjectDTO;
import com.wirelessmedia.domainobject.EmployeeDO;
import com.wirelessmedia.domainobject.ProjectDO;
import com.wirelessmedia.domainobject.TeamDO;
import com.wirelessmedia.domainvalue.EmployeeType;
import com.wirelessmedia.exception.EmplyeeMystBeJuniorOrMediorDeveloper;
import com.wirelessmedia.exception.EmplyeeMystBeTeamLead;
import com.wirelessmedia.service.employee.EmployeeService;
import com.wirelessmedia.service.project.ProjectService;
import com.wirelessmedia.service.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

public abstract class ProjectMapperDecorator implements ProjectMapper
{
    @Autowired
    private ProjectMapper delegate;

    @Autowired
    private TeamMapper teamMapper;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private EmployeeService employeeService;


    @Override public ProjectDO mapToProjectDO(ProjectDTO projectDTO) throws EmplyeeMystBeTeamLead, EmplyeeMystBeJuniorOrMediorDeveloper
    {
        ProjectDO projectDO = null;
        Optional<ProjectDO> entity = projectService.findProjectByName(projectDTO.getProjectName());

        if(entity.isPresent()){
            projectDO = entity.get();
        }else{
            projectDO = projectService.saveProject(delegate.mapToProjectDO(projectDTO));
        }
        if(projectDTO.getTeamName()!=null){
            TeamDO teamDO = teamMapper.mapToTeamDO(delegate.mapProjectDTOToTeamDTO(projectDTO));
            teamDO.getProjectDOs().add(projectDO);
            teamService.saveTeam(teamDO);
            projectDO.getTeamDOS().add(teamDO);
        }
        if(projectDTO.getProjectManagerPersonalNumber()!=null){
            Optional<EmployeeDO> employeeDO = employeeService.findEmployeeByPersonalNumber(projectDTO.getProjectManagerPersonalNumber());
            employeeDO.orElseThrow(() -> new EntityNotFoundException("No employee found with personal id " + projectDTO.getProjectManagerPersonalNumber()));
            if(!employeeDO.get().getEmployeeType().equals(EmployeeType.PROJECT_MANAGER)){
                throw new EmplyeeMystBeTeamLead("Employee must be a project manager!");
            }
            projectDO.setProjectManager(employeeDO.get());
        }

        return projectService.saveProject(projectDO);
    }
}
