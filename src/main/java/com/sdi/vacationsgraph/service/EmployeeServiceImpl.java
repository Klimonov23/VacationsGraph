package com.sdi.vacationsgraph.service;

import com.sdi.vacationsgraph.domain.Employee;
import com.sdi.vacationsgraph.dto.EmployeeDto;
import com.sdi.vacationsgraph.dto.EmployeeUpdDto;
import com.sdi.vacationsgraph.repository.DepartmentRepository;
import com.sdi.vacationsgraph.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private  final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    //TODO исправить на нужное исключение
    public Employee findByName(String name) {
        Assert.hasLength(name,
                () -> "Name for employee '" + name + "' must not be empty");
        Employee person=employeeRepository.findByName(name);
        if (person ==null)
            throw new RuntimeException("Such person doesn't exist");
        return person;
    }

    @Override
    public Employee createEmployee(EmployeeDto employeeDto) {
        if (employeeDto==null) return employeeRepository.save(new Employee());
        log.info(departmentRepository.findByName("Sales").toString());
        Employee employee=Employee.builder()
                .department(departmentRepository.findByName(employeeDto.getDepartment()))
                .hired(LocalDate.now())
                .name(employeeDto.getName())
                .position(employeeDto.getPosition())
                .build();

        return employeeRepository.save(employee);

    }

    @Override
    //TODO добавить проверку сравнения дто и объекта
    public Employee updateEmployee(EmployeeUpdDto employeeDto) {
        Employee savedUser=employeeRepository.findByName(employeeDto.getName());
        if (savedUser==null) throw new RuntimeException("not found"+employeeDto.getName());
        boolean isChanged=false;

        Employee employee=Employee.builder()
                .department(employeeDto.getDepartment())
                .hired(savedUser.getHired())
                .name(employeeDto.getName())
                .position(employeeDto.getPosition())
                .list(employeeDto.getList())
                .vacationDays(employeeDto.getVacationDays())
                .build();
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(String name) {
        Employee person=employeeRepository.findByName(name);
        if (person==null)  {
            log.info("such person doesn't exist");
            return;
        }
         employeeRepository.delete(person);
    }
}
