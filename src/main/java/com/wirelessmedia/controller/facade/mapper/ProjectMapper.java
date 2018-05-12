package com.wirelessmedia.controller.facade.mapper;

import com.wirelessmedia.datatransferobject.ProjectDTO;
import com.wirelessmedia.datatransferobject.ProjectRecord;
import com.wirelessmedia.datatransferobject.TeamDTO;
import com.wirelessmedia.datatransferobject.TeamRecord;
import com.wirelessmedia.domainobject.ProjectDO;
import com.wirelessmedia.domainobject.TeamDO;
import com.wirelessmedia.exception.EmplyeeMystBeJuniorOrMediorDeveloper;
import com.wirelessmedia.exception.EmplyeeMystBeTeamLead;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EmployeeMapper.class, TeamMapper.class})
@DecoratedWith(ProjectMapperDecorator.class)
public interface ProjectMapper
{
    @Mapping(target = "projectId", ignore = true)
    @Mapping(target = "projectManager", ignore = true)
    @Mapping(target = "teamDOS", ignore = true)
    ProjectDO mapToProjectDO(ProjectDTO projectDTO) throws EmplyeeMystBeTeamLead, EmplyeeMystBeJuniorOrMediorDeveloper;

    @Mapping(target = "teamRecords", source = "teamDOS")
    ProjectRecord mapToProjectRecord(ProjectDO projectDO);

    List<ProjectRecord> mapToProjectRecords(List<ProjectDO> projectDOS);

    @Mapping(target = "developerPersonalNumber", ignore = true)
    @Mapping(target = "teamLeadPersonalNumber", ignore = true)
    TeamDTO mapProjectDTOToTeamDTO(ProjectDTO projectDTO);
}
