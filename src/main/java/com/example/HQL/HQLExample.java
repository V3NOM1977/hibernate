package com.example.HQL;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.example.mappings.Student;

public class HQLExample {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        String queryString = "from Student";

        Query<Student> query = session.createQuery(queryString, Student.class);

        // query.setParameter("x", "BBA");

        // Student student = query.uniqueResult();
        // System.out.println(student);

        List<Student> students = query.list();
        students.forEach(student -> {
            System.out.println(student);
        });

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
