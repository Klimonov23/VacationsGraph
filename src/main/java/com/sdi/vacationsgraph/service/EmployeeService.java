package com.sdi.vacationsgraph.service;

import com.sdi.vacationsgraph.domain.Employee;
import com.sdi.vacationsgraph.dto.EmployeeDto;
import com.sdi.vacationsgraph.dto.EmployeeUpdDto;

public interface EmployeeService {
    Employee findByName(String name);

    Employee createEmployee(EmployeeDto employeeDto);

    Employee updateEmployee(EmployeeUpdDto employeeDto);

    void deleteEmployee(String name);

}
