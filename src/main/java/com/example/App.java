package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.models.Course;
import com.example.models.Student;
import com.example.models.ManyToMany.Employee;
import com.example.models.ManyToMany.Project;
import com.example.models.OneToOne.Answer;
import com.example.models.OneToOne.Question;

import jakarta.transaction.Transactional;

/**
 * Hello world!
 *
 */
public class App {

    @Transactional
    public static void main(String[] args) throws IOException {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        FileInputStream fileInputStream = new FileInputStream(new File("src/main/resources/image.png"));
        byte[] image = new byte[fileInputStream.available()];
        fileInputStream.read(image);

        Course course1 = new Course();
        course1.setCourseName("B.TECH");
        course1.setCourseDurationInYears(4);

        Student student1 = Student.builder()
                .studentName("Rishabh Rawat")
                .rollNo(67)
                .createdAt(new Date())
                .image(image)
                .course(course1)
                .temp(100)
                .build();

        Course course2 = new Course();
        course2.setCourseName("BBA");
        course2.setCourseDurationInYears(3);

        Student student2 = Student.builder()
                .studentName("Nishita Rawat")
                .rollNo(68)
                .createdAt(new Date())
                .image(image)
                .course(course2)
                .temp(100)
                .build();

        // Answer answer = new Answer("Chand pe");

        // Question question = new Question("Kahan ho bhai", answer);

        // Employee emp1 = new Employee();
        // emp1.setEmployeeName("Rishabh Rawat");

        // Employee emp2 = new Employee();
        // emp2.setEmployeeName("Nishita Rawat");

        // List<Employee> list = new ArrayList<>();
        // list.add(emp1);
        // list.add(emp2);

        // Project p1 = new Project();
        // p1.setProjectName(null);
        // p1.setEmployees(list);

        session.persist(student1);
        session.persist(student2);

        // session.persist(question);

        // session.persist(p1);

        System.out.println((Student) session.get(Student.class, 1));

        // System.out.println((Question) session.get(Question.class, 1));

        session.getTransaction().commit();
        session.close();

        /**
         * AT THIS <property name="hibernate.hbm2ddl.auto">create-drop</property>
         * PROPERTY,
         * WHEN THE sessionFactory gets close all data will be delete.
         */
        // sessionFactory.close();
    }

}
