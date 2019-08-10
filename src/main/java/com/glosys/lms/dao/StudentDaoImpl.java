package com.glosys.lms.dao;

import com.glosys.lms.entity.Student;

import javax.persistence.EntityManager;

public class StudentDaoImpl extends AbstractDao<Student> {
    public StudentDaoImpl(){
        super();
    }
    public StudentDaoImpl(EntityManager entityManager){
        super(entityManager);
    }

}
