package com.glosys.lms.controller;

import com.glosys.lms.entity.Workshop;
import com.glosys.lms.service.WorkshopService;

import java.time.LocalDate;
import java.util.List;

public class WorkshopController {
    private static WorkshopService workshopService = new WorkshopService();

    public void saveWorkshop(Workshop workshop){
        workshopService.saveWorkshop(workshop);
    }

    public boolean isExistingWorkshop(int workshopTypeId, int courseId, LocalDate date){
        return workshopService.isExistingWorkshop(workshopTypeId, courseId, date);
    }

    public List<Workshop> getAvailableAndFutureWorkshopsByStudentId(int studentId){
        return workshopService.getAvailableAndFutureWorkshopsByStudentId(studentId);
    }
}
