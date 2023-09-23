package com.sdi.vacationsgraph.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Entity
@Data//getter setter toString equals
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
    String position;
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    Department department;
    LocalDateTime hired;
    Integer vacationDays;
    @OneToMany( mappedBy = "employee",cascade = CascadeType.ALL, orphanRemoval = true)
    List<Vacation> list;
}
