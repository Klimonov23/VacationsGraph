package com.sdi.vacationsgraph.controller;


import com.sdi.vacationsgraph.domain.Department;
import com.sdi.vacationsgraph.domain.Employee;
import com.sdi.vacationsgraph.dto.DepartmentDto;
import com.sdi.vacationsgraph.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping(path = "/getAllEmployee/{name}")
    List<Employee> getEmployees(@PathVariable String name) {
        Department department = departmentService.findByName(name);
        return departmentService.getEmployees(department);
    }

    @PostMapping(path = "/create_dep")
    @ResponseStatus(HttpStatus.CREATED)
    Department createDepartment(@RequestBody DepartmentDto dto) {
        return departmentService.createDepartment(dto);
    }
}
