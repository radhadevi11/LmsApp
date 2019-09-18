package com.glosys.lms.controller;

import com.glosys.lms.entity.Trainer;
import com.glosys.lms.entity.TrainingProgram;
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

    public List<Trainer> getAllTrainers(){
        return trainerService.getAllTrainers();
    }

    public List<TrainingProgram> getTrainingPrograms(int trainerId){
        return trainerService.getTrainingPrograms(trainerId);
    }

    public Trainer getValidTrainer(String userName, String password){
        return trainerService.getValidTrainer(userName, password);

    }
}
