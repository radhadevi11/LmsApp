package com.glosys.lms.dao;

import com.glosys.lms.entity.Student;

import javax.persistence.EntityManager;

public class StudentHelper {
    public Student save(EntityManager em){
        StudentDaoImpl studentDao = new StudentDaoImpl(em);
        return studentDao.save(new Student());
    }
}
