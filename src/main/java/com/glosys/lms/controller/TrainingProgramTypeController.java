package com.glosys.lms.controller;

import com.glosys.lms.TrainingProgramType;
import service.TrainingProgramTypeService;

import java.util.List;

public class TrainingProgramTypeController {
    private static TrainingProgramTypeService trainingProgramTypeService = new TrainingProgramTypeService();

    public List<TrainingProgramType> getTrainingProgramTypes(){
        return trainingProgramTypeService.getTrainingProgramTypes();
    }
}
