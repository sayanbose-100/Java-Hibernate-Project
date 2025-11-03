package org.hibernatetut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
    public static void main(String[] args) {
        /*
         * Mainly
         */
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();

        Transaction tnx = session.beginTransaction();

        try {
            Student student = session.getReference(Student.class, 105);
            if(student != null) {
                System.out.println(student);
            }
            else {
                System.out.println("No Records found");
            }

        }
        catch(Exception e) {
            System.out.println("The error is:: "+e);
        }

        tnx.commit();
        factory.close();
    }
}

/*
Student student = session.find(Student.class, 105);
//        if(student != null) {
//            System.out.println("Student Id: "+student.getId());
//            System.out.println("Student Name: "+student.getName());
//            System.out.println("Student City: "+student.getCity());
//        }
//        else {
//            System.out.println("No records to print");
//        }
 */
