package com.example.relational_mappings.OneToMany;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

        // ONE TO MANY
        List<Book> books = new ArrayList<>();
        books.add(new Book("Programming in Java"));
        books.add(new Book("The joy of computing with Pyhton"));
        books.add(new Book("Programming in Mordern C++"));

        Author author = new Author("Rishabh Rawat", books);

        session.persist(author);

        // MANY TO ONE
        Book book1 = new Book("Diffrential Calculus", new Author("Nishita Rawat"));
        session.persist(book1);
        
        Book book2 = new Book("Integral Calculus", (Author) session.get(Author.class, 2));
        session.persist(book2);

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
