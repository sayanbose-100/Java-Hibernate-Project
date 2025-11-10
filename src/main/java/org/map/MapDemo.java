package org.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        /***********************
         * Creating a question *
         ***********************/
        Question q1 = new Question();
        q1.setQuestionId(1255);
        q1.setQuestion("What is Java?");

        Question q2 = new Question();
        q2.setQuestionId(1266);
        q2.setQuestion("What is Hibernate?");

        /*********************************************
         * Creating an answer for the above question *
         *********************************************/
        Answer answer1 = new Answer();
        answer1.setAnswerId(125);
        answer1.setAnswer("Java is a programming Language");
        answer1.setQuestion(q1);
        q1.setAnswer(answer1);

        Answer answer2 = new Answer();
        answer2.setAnswerId(126);
        answer2.setAnswer("Hibernate is a Java Framework used Object Relational Mapping");
        answer2.setQuestion(q2);
        q2.setAnswer(answer2);

        /**************************
         * Session Creation Start *
         **************************/
        Session session = factory.openSession();
        Transaction tnx = session.beginTransaction();

        /***********************************
         * Save the record in the database *
         ***********************************/
        session.persist(q1);
        session.persist(answer1);  // explicitly need to save this otherwise foreign key constraint error might occur
        session.persist(q2);
        session.persist(answer2);  // explicitly need to save this otherwise foreign key constraint error might occur
        /************************
         * Session Creation End *
         ************************/
        tnx.commit();
        session.close();
        factory.close();
    }
}