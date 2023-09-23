package com.sdi.vacationsgraph.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
@Data//getter setter toString equals
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="vacations")
public class Vacation {
    private static final String SEQ_NAME="vacation_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = SEQ_NAME)
    @SequenceGenerator(name=SEQ_NAME,sequenceName = SEQ_NAME,allocationSize = 1)
    Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    Employee employee;
    LocalDateTime vacationStart;
    LocalDateTime vacationFinish;
    Integer length;
    Boolean isPaid;
    @Enumerated(EnumType.STRING)
    VacationStatus status;
}
