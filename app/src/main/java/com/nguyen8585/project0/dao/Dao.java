package com.nguyen8585.project0.dao;

import com.nguyen8585.project0.entity.Student;

import java.util.List;

public interface Dao {
    public void insert(Student student);
    public List<Student> getAllStudents();
    public Student delete(int studentId);
    public Student search(int studentId);
    public Student update(Student student);
}
