package com.wirelessmedia.service.project;

import com.wirelessmedia.dataaccessobject.ProjectRepository;
import com.wirelessmedia.domainobject.ProjectDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService
{
    private ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository)
    {
        this.projectRepository = projectRepository;
    }


    @Override public Optional<ProjectDO> findProjectById(Long id)
    {
        return projectRepository.findById(id);
    }


    @Override public Optional<ProjectDO> findProjectByName(String projectName)
    {
        return projectRepository.findByProjectName(projectName);
    }


    @Override public ProjectDO saveProject(ProjectDO projectDO)
    {
        return projectRepository.save(projectDO);
    }


    @Override public void deleteProject(ProjectDO projectDO)
    {
        projectRepository.delete(projectDO);
    }


    @Override public List<ProjectDO> getAll()
    {
        return projectRepository.findAll();
    }
}
