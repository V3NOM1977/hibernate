package com.example.HQL;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.SelectionQuery;

import com.example.relational_mappings.Course;
import com.example.relational_mappings.Student;

import jakarta.transaction.Transactional;

public class HQLExample {

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

        // String queryString = "SELECT s FROM Student s WHERE s.course.courseName =:x";

        // SelectionQuery<Student> query = session.createSelectionQuery(queryString,
        // Student.class);

        // query.setParameter("x", "Maths Hons");

        // // Student student = query.uniqueResult();
        // // System.out.println(student);

        // List<Student> students = query.list();
        // students.forEach(student -> {
        // System.out.println(student);
        // });

        // String queryString = "DELETE FROM Student s WHERE s.id = :x";

        String queryString = "DELETE FROM Student s WHERE s.id = :x";

        int result = session.createMutationQuery(queryString).setParameter("x", 1).executeUpdate();
        System.out.println(result);

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
