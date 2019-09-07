package com.glosys.lms.dao;

import com.glosys.lms.entity.WorkshopType;

import javax.persistence.EntityManager;

public class WorkshopTypeHelper {
    public WorkshopType save(EntityManager em){
        WorkshopTypeDao workshopTypeDao = new WorkshopTypeDao(em);
        return workshopTypeDao.save(new WorkshopType());

    }
}
