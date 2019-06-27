package com.glosys.lms.controller;

import com.glosys.lms.Student;
import service.StudentService;

public class StudentController {
    private static StudentService studentService = new StudentService();

    public void saveStudent(Student student){
        studentService.saveStudent(student);
    }
}
