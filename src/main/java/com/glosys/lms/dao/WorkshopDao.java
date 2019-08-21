package com.glosys.lms.dao;

import com.glosys.lms.entity.Workshop;

import javax.persistence.EntityManager;

    public class WorkshopDao extends AbstractDao<Workshop> {
        public WorkshopDao() {super();}

        public WorkshopDao(EntityManager entityManager){
            super(entityManager);
        }


}
