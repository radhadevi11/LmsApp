package com.glosys.lms.controller;

import com.glosys.lms.entity.Student;
import com.glosys.lms.service.StudentService;

public class StudentController {
    private static StudentService studentService = new StudentService();

    public void saveStudent(Student student){
        studentService.saveStudent(student);
    }
}
