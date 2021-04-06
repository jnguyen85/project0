package com.nguyen8585.project0;

        import com.nguyen8585.project0.dao.StudentDao;
        import com.nguyen8585.project0.entity.Student;

        import com.nguyen8585.project0.studentapp.StudentApp;
        import com.nguyen8585.project0.ui.UI;
        import org.hibernate.Session;
        import org.hibernate.SessionFactory;
        import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        // Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        StudentDao studentDao = new StudentDao();

        StudentApp app = new StudentApp(factory, studentDao);

        app.start();

    }
}
