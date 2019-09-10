package com.glosys.lms.dao;

import com.glosys.lms.entity.Workshop;
import com.glosys.lms.entity.WorkshopEnrolment;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class WorkshopEnrolmentHelper {
    public WorkshopEnrolment save(EntityManager em, LocalDate localDate){
            WorkshopEnrolmentDao workshopEnrolmentDao = new WorkshopEnrolmentDao(em);
          return  workshopEnrolmentDao.save(new WorkshopEnrolment(new StudentHelper().save(em),
                     new WorkshopHelper().save(em,localDate)));
    }
}
