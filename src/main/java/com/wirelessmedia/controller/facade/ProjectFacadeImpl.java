package com.wirelessmedia.controller.facade;

import com.wirelessmedia.controller.facade.mapper.ProjectMapper;
import com.wirelessmedia.controller.facade.mapper.TeamMapper;
import com.wirelessmedia.datatransferobject.ProjectDTO;
import com.wirelessmedia.datatransferobject.ProjectRecord;
import com.wirelessmedia.datatransferobject.TeamDTO;
import com.wirelessmedia.datatransferobject.TeamRecord;
import com.wirelessmedia.exception.EmplyeeMystBeJuniorOrMediorDeveloper;
import com.wirelessmedia.exception.EmplyeeMystBeTeamLead;
import com.wirelessmedia.service.project.ProjectService;
import com.wirelessmedia.service.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ProjectFacadeImpl implements ProjectFacade
{
    private final ProjectService projectService;

    private final ProjectMapper projectMapper;

    @Autowired
    public ProjectFacadeImpl(ProjectService projectService, ProjectMapper projectMapper)
    {
        this.projectService = projectService;
        this.projectMapper = projectMapper;
    }


    @Override public ProjectRecord getProjectById(Long projectId)
    {
        return projectMapper.mapToProjectRecord(projectService.findProjectById(projectId).get());
    }


    @Override public ProjectRecord saveProject(ProjectDTO projectDTO) throws EmplyeeMystBeJuniorOrMediorDeveloper, EmplyeeMystBeTeamLead
    {
        return projectMapper.mapToProjectRecord(projectMapper.mapToProjectDO(projectDTO));
    }


    @Override public List<ProjectRecord> getAllProjects()
    {
        return projectMapper.mapToProjectRecords(projectService.getAll());
    }
}
