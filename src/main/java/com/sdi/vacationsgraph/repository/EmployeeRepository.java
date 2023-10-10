package com.sdi.vacationsgraph.repository;

import com.sdi.vacationsgraph.domain.Department;
import com.sdi.vacationsgraph.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Employee findByName(String name);
    List<Employee> findEmployeesByDepartment(Department department);

}
