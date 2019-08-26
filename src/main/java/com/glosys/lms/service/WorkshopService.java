package com.glosys.lms.service;

import com.glosys.lms.dao.DaoFactory;
import com.glosys.lms.entity.Workshop;

import java.time.LocalDate;
import java.util.List;

public class WorkshopService {
    public void saveWorkshop(Workshop workshop){
        DaoFactory.getWorkshopDao().save(workshop);

    }
    public boolean isExistingWorkshop(int workshopTypeId, int courseId, LocalDate date){
        return DaoFactory.getWorkshopDao().isExistingWorkshop(workshopTypeId, courseId, date);
    }

    public List<Workshop> getFutureWorkshops(){
        return DaoFactory.getWorkshopDao().getFutureWorkshops();
    }
}
