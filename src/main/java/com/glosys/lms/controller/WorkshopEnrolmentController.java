package com.glosys.lms.controller;

import com.glosys.lms.entity.WorkshopEnrolment;
import com.glosys.lms.service.WorkshopEnrolmentService;

public class WorkshopEnrolmentController {
    private static WorkshopEnrolmentService workshopEnrolmentService = new WorkshopEnrolmentService();

    public void saveWorkshopEnrolment(WorkshopEnrolment workshopEnrolment){
        workshopEnrolmentService.saveWorkshopEnrolment(workshopEnrolment);
    }
}
