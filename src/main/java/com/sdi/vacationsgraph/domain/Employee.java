package com.sdi.vacationsgraph.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Entity
@Getter
@Setter//getter setter toString equals
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "employees")
public class Employee {
    private static final String SEQ_NAME="employee_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = SEQ_NAME)
    @SequenceGenerator(name=SEQ_NAME,sequenceName = SEQ_NAME,allocationSize = 1)
    Long id;
    String name;
    String position; //должность
    @JsonIgnore
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    Department department;
    LocalDate hired;
    Integer vacationDays;
    @OneToMany( mappedBy = "employee",cascade = CascadeType.ALL, orphanRemoval = true)
    List<Vacation> list;
}
