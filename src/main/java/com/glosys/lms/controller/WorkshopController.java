package com.glosys.lms.controller;


import com.glosys.lms.model.WorkshopInfo;
import com.glosys.lms.service.WorkshopService;

public class WorkshopController {
    private static WorkshopService workshopService = new WorkshopService();

    public WorkshopInfo getWorkshopInfo(){
        return new WorkshopInfo(workshopService.getWorkshopTypes(),workshopService.getCourses());
    }
}
