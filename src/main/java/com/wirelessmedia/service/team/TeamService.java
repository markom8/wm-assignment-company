package com.wirelessmedia.service.team;

import com.wirelessmedia.domainobject.EmployeeDO;
import com.wirelessmedia.domainobject.TeamDO;

import java.util.List;
import java.util.Optional;

public interface TeamService
{
    Optional<TeamDO> findTeamById(Long id);

    Optional<TeamDO> findTeamByName(String name);

    TeamDO saveTeam(TeamDO teamDO);

    void deleteTeam(TeamDO teamDO);

    List<TeamDO> getAll();
}
