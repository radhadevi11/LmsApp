package com.glosys.lms.controller;

import com.glosys.lms.entity.Student;
import com.glosys.lms.entity.TrainingProgram;
import com.glosys.lms.service.StudentService;

import java.util.List;

public class StudentController {
    private static StudentService studentService = new StudentService();

    public void saveStudent(Student student){
        studentService.saveStudent(student);
    }

    public List<TrainingProgram> getSearchResults(String courseName, int studentId){
        return studentService.getSearchResults(courseName, studentId);
    }
}
