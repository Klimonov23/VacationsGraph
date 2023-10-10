package com.sdi.vacationsgraph.dto;

import com.sdi.vacationsgraph.domain.Department;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeDto {
    String name;
    String position; //должность
    Department department;
}
