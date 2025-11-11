package org.hql;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.map.Courses;
import org.map.Streams;

import java.util.Arrays;
import java.util.List;

public class HQL_Complex_Queries {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        Session session = factory.openSession();
        Transaction tnx = session.beginTransaction();

        /***********************************************************************
         * Before Running any queries verify ones, below there are DML Queries *
         * 1. Delete                                                           *
         * 2. Update                                                           *
         ***********************************************************************/


        /*****************
         * Delete Query  *
         *****************/
        String deleteQuery = "delete from Courses where course_id=:id";
        Query deleteCourseRecord = (Query) session.createMutationQuery(deleteQuery);
        deleteCourseRecord.setParameter("id", 3);
        try {
            int rowsAffected = deleteCourseRecord.executeUpdate();
            System.out.println("Deletion Operation performed. No of rows affected:: " + rowsAffected);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        /****************
         * Update Query *
         ****************/
        String updateQuery = "update Courses set subjects=:subjects where course_id=:id";
        Query updateCourseRecord = (Query) session.createMutationQuery(updateQuery);
        updateCourseRecord.setParameter("subjects", Arrays.asList("Financial Mathematics", "statistics", "Break Even Point Analysis", "Algebra"));
        updateCourseRecord.setParameter("id", 4);
        try {
            int rowsAffected = updateCourseRecord.executeUpdate();
            System.out.println("Update operation completed. No of rows affected:: " + rowsAffected);
        } catch (Exception e) {
            System.out.println("Update Operation ran into some problem");
            throw new RuntimeException(e);
        }

        /*************
         * SQL Joins *
         *************/
        String innerJoinQuery = "Select s.streamName , c.course_name from Streams as s INNER JOIN s.courses_provided as c";
        Query resultSet = session.createQuery(innerJoinQuery, Object.class);
        List<Object[]> result = resultSet.getResultList();
        for(Object[] stream : result) {
            System.out.println(Arrays.toString(stream));
        }

        tnx.commit();
        session.close();
        factory.close();
    }
}
