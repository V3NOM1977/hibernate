package com.example.models.OneToMany;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) throws IOException {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

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
