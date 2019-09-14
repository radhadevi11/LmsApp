package com.glosys.lms.dao;

import com.glosys.lms.entity.Trainer;

import javax.persistence.EntityManager;

public class TrainerHelper {
    public Trainer save(EntityManager em, String firstName){
        TrainerDao trainerDao = new TrainerDao(em);
        return trainerDao.save(new Trainer(firstName));
    }
}
