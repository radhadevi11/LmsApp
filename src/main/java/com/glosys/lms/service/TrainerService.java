package com.glosys.lms.service;

import com.glosys.lms.dao.DaoFactory;
import com.glosys.lms.entity.InplantTraining;
import com.glosys.lms.entity.Trainer;
import com.glosys.lms.entity.TrainingProgram;
import com.glosys.lms.entity.Workshop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<TrainingProgram> getTrainingPrograms(){
        Workshop workshop = new Workshop();
        InplantTraining inplantTraining = new InplantTraining();
        List<TrainingProgram> trainingPrograms = new ArrayList<>();
        trainingPrograms.add(workshop);
        trainingPrograms.add(inplantTraining);
        return trainingPrograms.stream().sorted().collect(Collectors.toList());

    }
}
