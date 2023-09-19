package com.example.relational_mappings.ManyToMany;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity(name = "projects")
public class Project {

    @Id
    @Column(name = "project_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long projectId;

    @Column(name = "project_name")
    private String projectName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "emp_project", joinColumns = { @JoinColumn(name = "project_id") }, inverseJoinColumns = {
            @JoinColumn(name = "employee_id") })
    private List<Employee> employees;

    public Project(String projectName) {
        this.projectName = projectName;
    }

    public Project(String projectName, List<Employee> employees) {
        this.projectName = projectName;
        this.employees = employees;
    }

}
