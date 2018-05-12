package com.wirelessmedia.controller;

import com.wirelessmedia.controller.facade.ProjectFacade;
import com.wirelessmedia.datatransferobject.ProjectDTO;
import com.wirelessmedia.datatransferobject.ProjectRecord;
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
@RequestMapping(path = "api/project")
public class ProjectController
{
    private final ProjectFacade projectFacade;

    @Autowired
    public ProjectController(ProjectFacade projectFacade)
    {
        this.projectFacade = projectFacade;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectRecord createOrUpdateProject(@Valid @RequestBody ProjectDTO projectDTO) throws ConstraintViolationException, EmplyeeMystBeJuniorOrMediorDeveloper, EmplyeeMystBeTeamLead
    {
        return projectFacade.saveProject(projectDTO);
    }

    @GetMapping("/{projectId}")
    public ProjectRecord getProject(@PathVariable Long projectId) throws EntityNotFoundException
    {
        return projectFacade.getProjectById(projectId);
    }

    @GetMapping
    public List<ProjectRecord> getProjects() throws EntityNotFoundException{
        return  projectFacade.getAllProjects();
    }
}
