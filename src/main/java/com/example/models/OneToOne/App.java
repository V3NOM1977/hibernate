package com.example.models.OneToOne;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.transaction.Transactional;

public class App {

    @Transactional
    public static void main(String[] args) throws IOException {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Question question1 = new Question("Kahan ho bhai?", new Answer("Chand pe."));
        session.persist(question1);
        Question question2 = new Question("Don ko kaise pakde?",
                new Answer("Don ko pakdna mushkil hi nahi namunkin hai."));
        session.persist(question2);

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
