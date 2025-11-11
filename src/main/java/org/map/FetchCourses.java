package org.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FetchCourses {
    public static void main(String[] args) {
        /*********************************
         * Building the Session Factory  *
         *********************************/
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        /**********************
         * Creating a Session *
         * And a Transaction  *
         **********************/
        Session session = factory.openSession();
        Transaction tnx = session.beginTransaction();

        try {
            Courses courses = session.getReference(Courses.class, 4);
            if(courses != null) System.out.println(courses);
            else System.out.println("Record not found");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
