package com.wirelessmedia.service.team;

import com.wirelessmedia.dataaccessobject.TeamRepository;
import com.wirelessmedia.domainobject.TeamDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TeamServiceImpl implements TeamService
{
    private TeamRepository teamRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository)
    {
        this.teamRepository = teamRepository;
    }


    @Override public Optional<TeamDO> findTeamById(Long id)
    {
        return teamRepository.findById(id);
    }


    @Override public Optional<TeamDO> findTeamByName(String name)
    {
        return teamRepository.findTeamDOByTeamName(name);
    }


    @Override public TeamDO saveTeam(TeamDO teamDO)
    {
        return teamRepository.save(teamDO);
    }


    @Override public void deleteTeam(TeamDO teamDO)
    {
        teamRepository.delete(teamDO);
    }


    @Override public List<TeamDO> getAll()
    {
        return teamRepository.findAll();
    }
}
