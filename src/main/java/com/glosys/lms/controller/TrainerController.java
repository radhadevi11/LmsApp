package com.glosys.lms.controller;

import com.glosys.lms.entity.Trainer;
import com.glosys.lms.service.TrainerService;

import java.time.LocalDate;
import java.util.List;

public class TrainerController {
    private static TrainerService trainerService = new TrainerService();

    public void saveTrainer(Trainer trainer){
        trainerService.saveTrainer(trainer);
    }

    public List<Trainer> getAvailableTrainers(LocalDate localDate){
        return trainerService.getAvailableTrainers(localDate);
    }
}
