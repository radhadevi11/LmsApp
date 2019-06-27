package com.glosys.lms.dao;

import com.glosys.lms.Student;

public class StudentDaoImpl extends AbstractDao<Student> {
    @Override
    protected Student createObject(Student student){
        return new Student(student.getFirstName(), student.getLastName(),student.getGender() , student.getMailId(),
                student.getCollegeName(), student.getPassword());

    }
}
