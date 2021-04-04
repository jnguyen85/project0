package com.nguyen8585.project0.dao;

import com.nguyen8585.project0.entity.Student;
import org.hibernate.Session;

public class StudentDao  implements Dao{
    private Session session;

    public StudentDao(Session session) {
        this.session = session;
    }

    @Override
    public void insert(Student student) {
        this.session.save(student);
    }
}
