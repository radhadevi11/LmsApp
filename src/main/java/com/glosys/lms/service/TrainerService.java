package com.glosys.lms.service;

import com.glosys.lms.dao.DaoFactory;
import com.glosys.lms.entity.Trainer;

import java.time.LocalDate;
import java.util.List;

public class TrainerService {
    public void saveTrainer(Trainer trainer){
        DaoFactory.getTrainerDao().save(trainer);
    }

    public List<Trainer> getAvailableTrainers(LocalDate localDate){
        return DaoFactory.getTrainerDao().getAvailableTrainers(localDate);
    }

    public List<Trainer> getAllTrainers(){
        return DaoFactory.getTrainerDao().getAllTrainers();
    }
}
