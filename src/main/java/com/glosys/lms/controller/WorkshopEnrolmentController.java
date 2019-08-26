package com.glosys.lms.controller;

import com.glosys.lms.entity.WorkshopEnrolment;
import com.glosys.lms.service.WorkshopEnrolmentService;

import java.util.List;

public class WorkshopEnrolmentController {
    private static WorkshopEnrolmentService workshopEnrolmentService = new WorkshopEnrolmentService();

    public void saveWorkshopEnrolment(WorkshopEnrolment workshopEnrolment){
        workshopEnrolmentService.saveWorkshopEnrolment(workshopEnrolment);
    }

    public List<WorkshopEnrolment> getAvailableWorkshopsForStudent(int studentId){
        return workshopEnrolmentService.getAvailableWorkshopsForStudent(studentId);
    }

    public List<WorkshopEnrolment> getEnrolmentsByStudentId(int studentId ){
        return workshopEnrolmentService.getEnrolmentsByStudentId(studentId);
    }
}
