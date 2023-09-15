package com.example.models.ManyToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.transaction.Transactional;

public class App {

    @Transactional
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        List<Employee> employees1 = new ArrayList<>();
        employees1.add(new Employee("Rishabh Rawat"));
        employees1.add(new Employee("Nishita Rawat"));

        Project project1 = new Project("Librec", employees1);

        session.persist(project1);

        List<Employee> employees2 = new ArrayList<>();
        employees2.add((Employee) session.get(Employee.class, 2));

        Project project2 = new Project("ChatApp", employees2);

        session.persist(project2);

        System.out.println((Project) session.get(Project.class, 1));
        System.out.println((Employee) session.get(Employee.class, 1));

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
