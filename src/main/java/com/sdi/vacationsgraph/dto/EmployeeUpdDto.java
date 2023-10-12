package com.sdi.vacationsgraph.dto;

import com.sdi.vacationsgraph.domain.Department;
import com.sdi.vacationsgraph.domain.Vacation;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeUpdDto {
     String name;
     String position; //должность
    Department department;
    LocalDate hired;
    Integer vacationDays;
    List<Vacation> list;
}
