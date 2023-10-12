package com.sdi.vacationsgraph.service;

import com.sdi.vacationsgraph.domain.Department;
import com.sdi.vacationsgraph.domain.Employee;
import com.sdi.vacationsgraph.domain.exceptions.NotFoundException;
import com.sdi.vacationsgraph.dto.DepartmentDto;
import com.sdi.vacationsgraph.dto.EmployeeDto;
import com.sdi.vacationsgraph.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    private final DepartmentRepository repository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Department findByName(String name) {
        Assert.hasLength(name,
                () -> "Name for department '" + name + "' must not be empty");
        Department department=repository.findByName(name);
        if (department ==null)
            throw new NotFoundException("Such person doesn't exist");
        return department;
    }

    @Override
    public Department createDepartment(DepartmentDto dto) {
        Employee boss=dto.getBoss()!=null ? Employee.builder()
                .vacationDays(28)
                .position(dto.getBoss().getPosition())
                .hired(LocalDate.parse(dto.getBoss().getHired(), DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .name(dto.getBoss().getName())
                .list(new ArrayList<>())
                .build() : null;
        Department department= Department.builder()
                .name(dto.getName())
                .boss(boss)
                .employees(new ArrayList<>())
                .build();
        if (boss!= null) department.getBoss().setDepartment(department);
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
        return repository.save(department);
    }

    @Override
    public boolean addEmployee(Department department, Employee employee) {
        if (employee!=null&& department!=null){
            department.getEmployees().add(employee);
            return true;
        }
        return false;
    }

    @Override
    public List<Employee> getEmployees(Department department) {
        if (department.getEmployees()==null) throw new NotFoundException("This department has no employee");
        return department.getEmployees();
    }
}
