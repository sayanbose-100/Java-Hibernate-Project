package org.hibernatetut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        Student student1 = new Student();
        student1.setId(123);
        student1.setName("Sayan");
        student1.setCity("CA");

        Certificate certificate1 = new Certificate();
        certificate1.setCourse(("Android Dev"));
        certificate1.setDuration("2 months");
        student1.setCerti(certificate1);

        Student student2 = new Student();
        Certificate certificate2 = new Certificate();
        certificate2.setCourse("Hibernate JPA");
        certificate2.setDuration("1 month");
        student2.setCerti(certificate2);
        student2.setId(2345);
        student2.setName("Rohini");
        student2.setCity("Texas");

        Session session = factory.openSession();
        Transaction tnx = session.beginTransaction();

        session.persist(student1);
        session.persist(student2);

        tnx.commit();
        session.close();
        factory.close();
    }
}
