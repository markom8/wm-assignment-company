package com.wirelessmedia.service.project;

import com.wirelessmedia.domainobject.ProjectDO;
import com.wirelessmedia.domainobject.TeamDO;

import java.util.List;
import java.util.Optional;

public interface ProjectService
{
    Optional<ProjectDO> findProjectById(Long id);

    Optional<ProjectDO> findProjectByName(String projectName);

    ProjectDO saveProject(ProjectDO projectDO);

    void deleteProject(ProjectDO projectDO);

    List<ProjectDO> getAll();
}
