package com.glosys.lms.controller;

import com.glosys.lms.entity.Workshop;
import com.glosys.lms.service.WorkshopService;

public class WorkshopController {
    private static WorkshopService workshopService = new WorkshopService();

    public void saveWorkshop(Workshop workshop){
        workshopService.saveWorkshop(workshop);
    }
}
