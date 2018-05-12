package com.wirelessmedia.dataaccessobject;

import com.wirelessmedia.domainobject.TeamDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface TeamRepository extends JpaRepository<TeamDO, Long>
{
    Optional<TeamDO> findTeamDOByTeamName(String teamName);
}
