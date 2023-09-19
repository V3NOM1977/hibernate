package com.example.relational_mappings.ManyToMany;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity(name = "employees")
public class Employee {

    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId;

    @Column(name = "employee_name")
    private String employeeName;

    @ManyToMany(mappedBy = "employees")
    private List<Project> projects;

    public Employee(String employeeName) {
        this.employeeName = employeeName;
    }

}
