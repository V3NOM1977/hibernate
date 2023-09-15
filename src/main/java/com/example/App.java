package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.models.Course;
import com.example.models.Student;

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

        session.persist(student1);

        Course course2 = new Course();
        course2.setCourseName("Maths Hons");
        course2.setCourseDurationInYears(3);

        Student student2 = Student.builder()
                .studentName("Nishita Rawat")
                .rollNo(68)
                .createdAt(new Date())
                .image(image)
                .course(course2)
                .temp(100)
                .build();

        session.persist(student2);

        System.out.println((Student) session.get(Student.class, 1));

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
