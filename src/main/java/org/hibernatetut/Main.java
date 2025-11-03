package org.hibernatetut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Testing the Session Factory");
        /*********************************************************
         * Session Factory helps us to create sessions and       *
         * sessions help to create objects and save them in the  *
         * database.                                             *
         * Session Factory is an Interface                       *
         *********************************************************/
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        /*
         * Creating a student
         */
        Student s1 = new Student(105, "Argentin", "Latin AM");
        System.out.println(s1);

        /*
         * Creating a address
         */
        Address a1 = new Address();
        a1.setStreet("Street 1");
        a1.setCity("CITY 1");
        a1.setOpen(true);
        a1.setAddedDate(new Date());
        a1.setX(1234.23);

        // Reading an image
        FileInputStream fis = new FileInputStream("src/main/assets/Bart.png");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        a1.setImage(data);

        System.out.println(a1);

        /*
         * Factory has the session with which the Student Object can be saved inside the DB
         */
        Session session = factory.openSession();
        System.out.println("The current session is:: "+ session);
        Transaction tx = session.beginTransaction();
//        session.persist(s1);
        session.persist(a1);
        tx.commit();
        session.close();
        System.out.println("Done....");
    }
}