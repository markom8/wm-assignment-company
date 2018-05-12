package com.wirelessmedia.controller.facade;

import com.wirelessmedia.datatransferobject.ProjectDTO;
import com.wirelessmedia.datatransferobject.ProjectRecord;
import com.wirelessmedia.datatransferobject.TeamDTO;
import com.wirelessmedia.datatransferobject.TeamRecord;
import com.wirelessmedia.exception.EmplyeeMystBeJuniorOrMediorDeveloper;
import com.wirelessmedia.exception.EmplyeeMystBeTeamLead;

import java.util.List;

public interface ProjectFacade
{
    ProjectRecord getProjectById(Long projectId);

    ProjectRecord saveProject(ProjectDTO projectDTO) throws EmplyeeMystBeJuniorOrMediorDeveloper, EmplyeeMystBeTeamLead;

    List<ProjectRecord> getAllProjects();
}
