package org.hql;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.map.Courses;

import java.util.List;

public class HQLBasic {
    public static void main(String[] args) {
        /******************************
         * Creating a session factory *
         ******************************/
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        /********************
         * Session Creation *
         ********************/
        Session session = factory.openSession();

        /****************************
         * Hibernate Query Creation with a dynamic id field*
         ****************************/
        String query = "from Courses where course_id=:id";
        /*
         * Query creation
         */
        Query allCoursesQuery = session.createQuery(query);
        /*
         * Setting the parameter for the id as 6
         */
        allCoursesQuery.setParameter("id", 6);
        /*
         * Retrieving the result in the form of a list
         */
        List<Courses> courseList = allCoursesQuery.getResultList();
        /*
         * Checking for empty list and applying null checks
         */
        if(!courseList.isEmpty()) {
            System.out.println("********* COURSES ********");
            for (Courses course : courseList) {
                System.out.println(course.getCourse_name() + "\t" + "- " + String.join("," , course.getSubjects()));
            }
        }  else {
            System.out.println("No courses found with this id");
        }
        factory.close();
    }
}
