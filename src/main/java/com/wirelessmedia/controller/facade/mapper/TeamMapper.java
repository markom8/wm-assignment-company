package com.wirelessmedia.controller.facade.mapper;

import com.wirelessmedia.datatransferobject.EmployeeDTO;
import com.wirelessmedia.datatransferobject.TeamDTO;
import com.wirelessmedia.datatransferobject.TeamRecord;
import com.wirelessmedia.domainobject.EmployeeDO;
import com.wirelessmedia.domainobject.TeamDO;
import com.wirelessmedia.exception.EmplyeeMystBeJuniorOrMediorDeveloper;
import com.wirelessmedia.exception.EmplyeeMystBeTeamLead;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EmployeeMapper.class})
@DecoratedWith(TeamMapperDecorator.class)
public interface TeamMapper
{
    @Mapping(target = "teamId", ignore = true)
    @Mapping(target = "developers", ignore = true)
    @Mapping(target = "teamLead", ignore = true)
    @Mapping(target = "projectDOs", ignore = true)
    TeamDO mapToTeamDO(TeamDTO teamDTO) throws EmplyeeMystBeJuniorOrMediorDeveloper, EmplyeeMystBeTeamLead;

    TeamRecord mapToTeamRecord(TeamDO teamDO);

    List<TeamRecord> mapToTeamRecords(List<TeamDO> teamDOS);
}
