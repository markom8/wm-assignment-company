package com.wirelessmedia.dataaccessobject;

import com.wirelessmedia.domainobject.ProjectDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface ProjectRepository extends JpaRepository<ProjectDO, Long>
{
    Optional<ProjectDO> findByProjectName(String projectName);
}
