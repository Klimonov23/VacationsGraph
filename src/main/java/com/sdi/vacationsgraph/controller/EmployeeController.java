package com.sdi.vacationsgraph.controller;

import com.sdi.vacationsgraph.domain.Employee;
import com.sdi.vacationsgraph.dto.EmployeeDto;
import com.sdi.vacationsgraph.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping(path = "/createEmployee")
    @ResponseStatus(HttpStatus.CREATED)
    Employee createEmployee(@RequestBody EmployeeDto dto){
        return service.createEmployee(dto);
    }
}
