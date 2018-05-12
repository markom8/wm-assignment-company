package com.wirelessmedia.dataaccessobject;

import com.wirelessmedia.domainobject.EmployeeDO;
import com.wirelessmedia.domainobject.ProjectDO;
import com.wirelessmedia.domainobject.TaskDO;
import com.wirelessmedia.domainobject.TimeSheetDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface TimeSheetRepository extends JpaRepository<TimeSheetDO, Long>
{
    Optional<TimeSheetDO> findByProjectDOAndEmployeeDOAndTaskDOAndDate(ProjectDO projectDO, EmployeeDO employeeDO, TaskDO taskDO, Date date);

    List<TimeSheetDO> findByProjectDOAndEmployeeDO(ProjectDO projectDO, EmployeeDO employeeDO);
}
