package com.glosys.lms.service;

import com.glosys.lms.dao.DaoFactory;
import com.glosys.lms.dao.InplantTrainingDao;
import com.glosys.lms.dao.WorkshopDao;
import com.glosys.lms.entity.InplantTraining;
import com.glosys.lms.entity.Trainer;
import com.glosys.lms.entity.TrainingProgram;
import com.glosys.lms.entity.Workshop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainerService  {

    public void saveTrainer(Trainer trainer){
        DaoFactory.getTrainerDao().save(trainer);
    }

    public List<Trainer> getAvailableTrainers(LocalDate localDate){
        return DaoFactory.getTrainerDao().getAvailableTrainers(localDate);
    }

    public List<Trainer> getAllTrainers(){
        return DaoFactory.getTrainerDao().getAllTrainers();
    }

    public List<TrainingProgram> getTrainingPrograms(int trainerId){
        return getTrainingPrograms(trainerId,DaoFactory.getWorkshopDao(), DaoFactory.getInplantTrainingDao());
    }

     List<TrainingProgram> getTrainingPrograms(int trainerId, WorkshopDao workshopDao,
                                                     InplantTrainingDao inplantTrainingDao){
        List<TrainingProgram> trainingPrograms = new ArrayList<>();
        List<Workshop> workshops = workshopDao.getWorkshopTrainings(trainerId);
        for (Workshop workshop : workshops){
            trainingPrograms.add(workshop);
        }
        List<InplantTraining> inplantTrainings = inplantTrainingDao.getInplantTrainings(trainerId);
        for (InplantTraining inplantTraining : inplantTrainings){
            trainingPrograms.add(inplantTraining);
        }
        return trainingPrograms.stream().sorted().collect(Collectors.toList());

    }

    public Trainer getValidTrainer(String userName, String password){
        return DaoFactory.getTrainerDao().getValidTrainer(userName, password);
    }
}
