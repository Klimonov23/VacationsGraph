package com.sdi.vacationsgraph.dto;


import com.sdi.vacationsgraph.domain.Employee;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentDto {
    String name;
    EmployeeDto boss;
    List<EmployeeDto> employees;
}
