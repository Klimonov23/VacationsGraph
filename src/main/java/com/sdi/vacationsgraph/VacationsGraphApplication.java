package com.sdi.vacationsgraph;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class VacationsGraphApplication {

    public static void main(String[] args) {
        SpringApplication.run(VacationsGraphApplication.class, args);
        //System.out.println(LocalDate.parse("2020-01-01", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }

}
