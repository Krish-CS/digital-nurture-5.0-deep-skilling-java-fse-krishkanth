package com.ems.repository.secondary;

import com.ems.entity.secondary.DepartmentAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentAuditRepository extends JpaRepository<DepartmentAudit, Long> {
    List<DepartmentAudit> findByDepartmentId(Long departmentId);
}
