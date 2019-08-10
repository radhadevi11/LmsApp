package com.glosys.lms.service;

import com.glosys.lms.dao.DaoFactory;
import com.glosys.lms.entity.WorkshopEnrolment;

public class WorkshopEnrolmentService {
    public void saveWorkshopEnrolment(WorkshopEnrolment workshopEnrolment){
         DaoFactory.getWorkshopEnrolmentDao().save(workshopEnrolment);
    }
}
