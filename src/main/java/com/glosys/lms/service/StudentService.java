package com.glosys.lms.service;

import com.glosys.lms.entity.Student;
import com.glosys.lms.dao.DaoFactory;

public class StudentService {
    public void saveStudent(Student student){
        DaoFactory.getStudentDao().save(student);
    }

}
