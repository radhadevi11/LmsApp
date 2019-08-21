package com.glosys.lms.service;

import com.glosys.lms.dao.DaoFactory;
import com.glosys.lms.entity.Workshop;

public class WorkshopService {
    public void saveWorkshop(Workshop workshop){
        DaoFactory.getWorkshopDao().save(workshop);

    }
}
