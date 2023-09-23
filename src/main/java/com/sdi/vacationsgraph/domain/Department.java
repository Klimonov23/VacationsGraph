package com.sdi.vacationsgraph.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data//getter setter toString equals
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "departments")
public class Department {
    private static final String SEQ_NAME="department_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = SEQ_NAME)
    @SequenceGenerator(name=SEQ_NAME,sequenceName = SEQ_NAME,allocationSize = 1)
    Long id;
    String name;
    @OneToOne
    @JoinColumn(name="employee_id")
    Employee boss;
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    List<Employee> employees;
}
