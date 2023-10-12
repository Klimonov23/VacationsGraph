package com.sdi.vacationsgraph.service;

import com.sdi.vacationsgraph.domain.Employee;
import com.sdi.vacationsgraph.dto.EmployeeDto;

public interface EmployeeService {
    Employee findByName(String name);

    Employee createEmployee(EmployeeDto employeeDto);

    Employee updateEmployee(EmployeeDto employeeDto);

    void deleteEmployee(String name);

}
