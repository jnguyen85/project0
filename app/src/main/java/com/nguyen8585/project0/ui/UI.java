package com.nguyen8585.project0.ui;


import com.nguyen8585.project0.entity.Student;

import java.util.List;
import java.util.Scanner;

public class UI {

    public static int mainMenu(Scanner scanner) {
        System.out.println("------MENU---------");
        System.out.println("1. Display all students");
        System.out.println("2. Add a student");
        System.out.println("3. Update a student");
        System.out.println("4. Remove a student");
        System.out.println("5. Search a student");
        System.out.println("6. Write all students to JSON file");

        System.out.println("Enter choice: ");

        return scanner.nextInt();
    }

    public static Student insertStudent(Scanner scanner) {
        String firstName;
        String lastName;
        String email;

        System.out.println(" ");
        System.out.println(" ");

        System.out.println("********Adding a student*******");
        scanner.nextLine();

        System.out.println("Enter first name: ");
        firstName = scanner.nextLine();
        System.out.println("Enter last name: ");
        lastName = scanner.nextLine();
        System.out.println("Enter email: ");
        email = scanner.nextLine();

        System.out.println(" ");
        System.out.println("********** Student saved *************");

        return new Student(firstName, lastName, email);
    }

    public static void displayAllStudents(List<Student> students) {
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("************ Displaying all students *************");
        for(Student student : students) {
            System.out.println(student);
        }

        System.out.println(" ");
        System.out.println("****************************************");
    }

    public static void displayInsertedStudent(Student student) {
        System.out.println(" ");
        System.out.println("************* Student Inserted ************ ");
        System.out.println(student);
        System.out.println(" ");
        System.out.println(" ");
    }

    public static void displayUpdatedStudent(Student student) {
        System.out.println(" ");
        System.out.println("******* Student Updated ************* ");
        System.out.println(student);
        System.out.println(" ");
        System.out.println(" ");
    }


    public static void displayDeletedStudent(Student student) {
        System.out.println(" ");
        System.out.println("*********** Student Deleted *********");
        System.out.println(student);
        System.out.println(" ");
        System.out.println(" ");
    }

    public static void displaySearchedStudent(Student student) {
        System.out.println(" ");
        System.out.println("******* Search Found ************* ");
        System.out.println("Searched student: " + student);
        System.out.println(" ");
        System.out.println(" ");
    }

    public static void displayFileNameWrittenToDisk(String fileName) {
        System.out.println(" ");
        System.out.println("******* File Written to Disk ************* ");
        System.out.println(fileName);
        System.out.println(" ");
        System.out.println(" ");
    }


    public static int deleteStudent(Scanner scanner) {
        int id;
        System.out.println("Enter student id to be deleted: ");
        id = scanner.nextInt();
        return id;
    }

    public static int searchStudent(Scanner scanner) {
        int id;
        System.out.println("Enter student id to be searched: ");
        id = scanner.nextInt();
        return id;
    }

    public static Student updateStudent(Scanner scanner) {
        Student student = new Student();
        System.out.println("Enter student id: ");
        student.setId(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Enter student first name to be updated: ");
        student.setFirstName(scanner.nextLine());
        System.out.println("Enter student last name to be updated: ");
        student.setLastName(scanner.nextLine());
        System.out.println("Enter student email to be updated: ");
        student.setEmail(scanner.nextLine());

        return student;
    }

    public static String getFileName(Scanner scanner) {
        String fileName = "student_records.txt";

        System.out.println(" ");
        System.out.println("Please enter file name: ");
        scanner.nextLine();
        fileName = scanner.nextLine();
        fileName += ".txt";
        return fileName;

    }
}
