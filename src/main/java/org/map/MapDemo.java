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
        q1.setQuestionId(1211);
        q1.setQuestion("What is Java?");

        /*********************************************
         * Creating an answer for the above question *
         *********************************************/
        Answer answer1 = new Answer();
        answer1.setAnswerId(121);
        answer1.setAnswer("Java is a programming Language");
        q1.setAnswer(answer1);

        /**************************
         * Session Creation Start *
         **************************/
        Session session = factory.openSession();
        Transaction tnx = session.beginTransaction();

        /***********************************
         * Save the record in the database *
         ***********************************/
        session.persist(q1);
        /************************
         * Session Creation End *
         ************************/
        tnx.commit();
        session.close();
        factory.close();
    }
}