package com.nguyen8585.project0;

import java.util.Properties;

import com.nguyen8585.project0.dao.StudentDao;
import com.nguyen8585.project0.entity.Student;

import com.nguyen8585.project0.ui.UI;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Hibernate 5.4 SessionFactory example without XML
        Map<String, String> settings = new HashMap<>();
        // settings.put("connection.driver_class", "com.mysql.jdbc.Driver");
        // settings.put("dialect", "org.hibernate.dialect.MySQLDialect");
        // settings.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&amp;serverTimezone=UTC");
        // settings.put("hibernate.connection.username", "hbstudent");
        // settings.put("hibernate.connection.password", "hbstudent");
        // settings.put("hibernate.current_session_context_class", "thread");
        // settings.put("hibernate.connection.pool_size", "1");
        // settings.put("hibernate.show_sql", "true");
        // settings.put("hibernate.format_sql", "true");

        // ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
        //                                     .applySettings(settings).build();

        // MetadataSources metadataSources = new MetadataSources(serviceRegistry);
        // metadataSources.addAnnotatedClass(Student.class);
        // Metadata metadata = metadataSources.buildMetadata();
        //metadata.getSessionFactoryBuilder().build();
        // // Create session factory
        SessionFactory factory = 
        new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        StudentDao studentDao = new StudentDao(session);
        UI gui = new UI();

        try {
            gui.menu();
            // create a student object
            System.out.println("Creating new student object...");
            Student tempStudent = new Student("Mary", "Heart", "mary@luv2code.com");

            // start a transaction
            session.beginTransaction();

            // Save the student object
            System.out.println("Saving the student");
            studentDao.insert(tempStudent);
            System.out.println(tempStudent.getId());



            // commit transaction
            session.getTransaction().commit();

        } catch(Exception e) {
            e.printStackTrace();
        }finally {
            factory.close();
        }
    }
}
