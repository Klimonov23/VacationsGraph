package com.sdi.vacationsgraph.repository;

import com.sdi.vacationsgraph.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Department findByName(String string);
}
