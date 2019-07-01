package com.glosys.lms.controller;


import com.glosys.lms.model.WorkshopInfo;
import service.WorkshopService;

import java.util.List;

public class WorkshopController {
    private static WorkshopService workshopService = new WorkshopService();

    public WorkshopInfo getWorkshopInfo(){
        return new WorkshopInfo(workshopService.getWorkshopTypes(),workshopService.getCourses());
    }
}
