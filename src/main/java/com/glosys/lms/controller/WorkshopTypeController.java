package com.glosys.lms.controller;


import com.glosys.lms.model.WorkshopInfo;
import com.glosys.lms.service.WorkshopTypeService;

public class WorkshopTypeController {
    private static WorkshopTypeService workshopTypeService = new WorkshopTypeService();

    public WorkshopInfo getWorkshopInfo(){
        return new WorkshopInfo(workshopTypeService.getWorkshopTypes(), workshopTypeService.getCourses());
    }
}
