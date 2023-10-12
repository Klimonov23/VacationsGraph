package com.sdi.vacationsgraph.controller;

import com.sdi.vacationsgraph.domain.Department;
import com.sdi.vacationsgraph.domain.Employee;
import com.sdi.vacationsgraph.dto.DepartmentDto;
import com.sdi.vacationsgraph.dto.EmployeeDto;
import com.sdi.vacationsgraph.repository.DepartmentRepository;
import com.sdi.vacationsgraph.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@RestController
public class MainController {
    private final EmployeeService service;
    private final DepartmentRepository rep;

    @Autowired
    public MainController(EmployeeService service, DepartmentRepository rep) {
        this.service = service;
        this.rep = rep;
    }

    @PostMapping(path = "/create")
    Employee createEmployee(EmployeeDto dto){
        return service.createEmployee(dto);
    }

    @PostMapping(path = "/create_dep",consumes = "application/json", produces = "application/json")
    Department createDepartment(@RequestBody DepartmentDto dto){
        System.out.println(dto.getBoss());
        System.out.println(dto.getName());
        Department department= Department.builder()
                .name(dto.getName())
                .boss(Employee.builder()
                        .vacationDays(28)
                        .position(dto.getBoss().getPosition())
                        .hired(LocalDate.parse(dto.getBoss().getHired(), DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                        .name(dto.getBoss().getName())
                        .list(new ArrayList<>())
                        .build())
                .employees(new ArrayList<>())
                .build();
        department.getBoss().setDepartment(department);
        if ( dto.getEmployees()!=null && !dto.getEmployees().isEmpty() ){
        for (EmployeeDto employeeDto : dto.getEmployees()){
            Employee person= Employee.builder()
                    .vacationDays(28)
                    .position(employeeDto.getPosition())
                    .hired(LocalDate.parse(employeeDto.getHired(), DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                    .name(employeeDto.getName())
                    .department(department)
                    .list(new ArrayList<>())
                    .build();
            department.getEmployees().add(person);
        }}

        //System.out.println(department.toString());
        return rep.save(department);
    }
}
