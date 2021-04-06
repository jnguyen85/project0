package com.nguyen8585.project0.studentapp;

import com.nguyen8585.project0.dao.StudentDao;
import com.nguyen8585.project0.entity.Student;
import com.nguyen8585.project0.ui.UI;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StudentApp {
    public static final int READ = 1;
    public static final int CREATE = 2;
    public static final int UPDATE = 3;
    public static final int DELETE = 4;
    public static final int SEARCH = 5;
    public static final int JSON = 6;

    private SessionFactory factory;
    private StudentDao studentDao;

    public StudentApp(SessionFactory factory, StudentDao studentDao) {
        this.factory = factory;
        this.studentDao = studentDao;
    }

    public void start() {
        // Create Scanner to interact with user/client
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int choice = 5;

        while(!quit) {
            try {
                // Get Session to do CRUD with database
                Session session = factory.getCurrentSession();

                // Create a Data Access Object
                this.studentDao.setSession(session);

                choice = UI.mainMenu(scanner);

                switch(choice) {
                    case READ:
                        List<Student> students = this.studentDao.getAllStudents();
                        UI.displayAllStudents(students);

                        break;
                    case CREATE:
                        // Get student info to be saved into database
                        Student insertStudent = UI.insertStudent(scanner);

                        // Save the student object into database
                        this.studentDao.insert(insertStudent);

                        // Display the student that was saved into database
                        UI.displayInsertedStudent(insertStudent);

                        break;
                    case UPDATE:
                        Student updateStudent = UI.updateStudent(scanner);
                        this.studentDao.update(updateStudent);
                        UI.displayUpdatedStudent(updateStudent);
                        break;
                    case DELETE:
                        int deleteStudentId = UI.deleteStudent(scanner);
                        Student deleteStudent = this.studentDao.delete(deleteStudentId);
                        UI.displayDeletedStudent(deleteStudent);
                        break;
                    case SEARCH:
                        int searchStudentId = UI.searchStudent(scanner);
                        Student searchStudent = this.studentDao.search(searchStudentId);
                        UI.displaySearchedStudent(searchStudent);
                        break;
                    case JSON:
                        String fileName = UI.getFileName(scanner);
                        this.studentDao.writeJsonToFile(fileName);
                        UI.displayFileNameWrittenToDisk(fileName);
                        break;
                    default:
                        break;
                } // end switch
            } catch (InputMismatchException ie) {
                choice = 5;
                quit = true;
            } catch (Exception e) {
                choice = 5;
                quit = true;
            } // end try and catch
        } // end while loop

        System.out.println("----- END OF PROGRAM -------");
    }
}
