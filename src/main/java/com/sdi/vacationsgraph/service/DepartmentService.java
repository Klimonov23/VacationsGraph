package com.sdi.vacationsgraph.service;

import com.sdi.vacationsgraph.domain.Department;
import com.sdi.vacationsgraph.domain.Employee;
import com.sdi.vacationsgraph.dto.DepartmentDto;
import com.sdi.vacationsgraph.dto.EmployeeDto;

import java.util.List;

public interface DepartmentService {

    Department findByName(String name);

    Department createDepartment(DepartmentDto departmentDto);

    boolean addEmployee(Department department, Employee employee);

    List<Employee> getEmployees(Department department);


}
