package com.nguyen8585.project0.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nguyen8585.project0.entity.Student;
import org.hibernate.Session;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class StudentDao  implements Dao{
    private Session session;

    @Override
    public List<Student> getAllStudents() {
        this.session.beginTransaction();
        List<Student> students = session.createQuery("from Student").getResultList();
        this.session.getTransaction().commit();
        return students;
    }

    @Override
    public void insert(Student student) {
        this.session.beginTransaction();
        this.session.save(student);
        this.session.getTransaction().commit();
    }


    @Override
    public Student update(Student student) {
        this.session.beginTransaction();
        Student myStudent = session.get(Student.class, student.getId());
        myStudent.setFirstName(student.getFirstName());
        myStudent.setLastName(student.getLastName());
        myStudent.setEmail(student.getEmail());
        this.session.getTransaction().commit();
        return myStudent;
    }


    @Override
    public Student delete(int studentId) {
        this.session.beginTransaction();
        Student myStudent = session.get(Student.class, studentId);
        // Delete the student
        session.delete(myStudent);
        this.session.getTransaction().commit();
        return myStudent;
    }

    @Override
    public Student search(int studentId) {
        this.session.beginTransaction();
        Student myStudent = session.get(Student.class, studentId);
        this.session.getTransaction().commit();
        return myStudent;
    }

    public void writeJsonToFile(String fileName) {
        List<Student> students = this.getAllStudents();
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(students);
        try {
            FileWriter fw = new FileWriter(fileName);
            fw.write(json);
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(json);
    }

    public void setSession(Session session) {
        this.session = session;
    }
}


