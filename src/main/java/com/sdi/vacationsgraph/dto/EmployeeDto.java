package com.sdi.vacationsgraph.dto;

import com.sdi.vacationsgraph.domain.Vacation;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeDto {
     String name;
     String position; //должность
     String departmentName;
     String  hired;
     Integer vacationDays;
     List<Vacation> list;
}
