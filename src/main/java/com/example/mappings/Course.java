package com.example.mappings;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;;

@Data
@Embeddable
public class Course {

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_duration_in_years")
    private int courseDurationInYears;

}
