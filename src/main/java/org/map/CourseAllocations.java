package org.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class CourseAllocations {
    public static void main(String[] args) {
        /********************************
         * Building the Session Factory *
         ********************************/
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        /********************************
         * Creating Streams and Courses *
         ********************************/
        Streams stream1 = new Streams();
        stream1.setStreamId("s01");
        stream1.setStreamName("Science");

        Streams stream2 = new Streams();
        stream2.setStreamId("s02");
        stream2.setStreamName("Commerce");

        Courses course1 = new Courses();
        course1.setCourse_id(1);
        course1.setCourse_name("Computer Science");
        course1.setSubjects(Arrays.asList("Java","C++", "OOPs", "DBMS", "Networking"));
        course1.setStream(stream1);

        Courses course2 = new Courses();
        course2.setCourse_id(2);
        course2.setCourse_name("Physics");
        course2.setSubjects(Arrays.asList("Thermodynamics", "Optics", "Mechanics", "Non-Newtonian Fluids", "Fluid Dynamics"));
        course2.setStream(stream1);

        Courses course3 = new Courses();
        course3.setCourse_id(3);
        course3.setCourse_name("Accounts");
        course3.setSubjects(Arrays.asList("Double Entry", "Financial Systems", "Depreciation and Amortization", "Accrual Accounting"));
        course3.setStream(stream2);

        Courses course4 = new Courses();
        course4.setCourse_id(4);
        course4.setCourse_name("Economics");
        course4.setSubjects(Arrays.asList("Macroeconomics", "Microeconomics", "Economic Growth Theory", "Monetary and Fiscal Policy"));
        course4.setStream(stream2);

        Courses course5 = new Courses();
        course5.setCourse_id(5);
        course5.setCourse_name("Business Mathematics");
        course5.setSubjects(Arrays.asList("Financial Mathematics", "statistics", "Break Even Point Analysis"));
        course5.setStream(stream2);

        /*
         * Attaching the courses to the stream
         */
        stream1.setCourses_provided(Arrays.asList(course1, course2));
        stream2.setCourses_provided(Arrays.asList(course3, course4, course5));

        /******************************************
         * Starting a new Session and Transaction *
         ******************************************/
        Session session = factory.openSession();
        Transaction tnx = session.beginTransaction();

        /***************************************************
         * Storing the entities in the persistent database *
         ***************************************************/
        /*
         * Storing the courses at first in the DB
         * Not needed to perform explicitly as we have used Cascade operation
         */
//        session.persist(course1);
//        session.persist(course2);

        /*
         * Allocating courses to the Streams
         */
        session.persist(stream1);
        session.persist(stream2);

        /*****************************************************
         * Committing the transaction and ending the session *
         *****************************************************/
        tnx.commit();
        session.close();
        factory.close();
    }
}
