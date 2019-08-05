package com.glosys.lms.service;

import com.glosys.lms.entity.TrainingProgramType;
import com.glosys.lms.dao.DaoFactory;

import java.util.List;

public class TrainingProgramTypeService {
    public List<TrainingProgramType> getTrainingProgramTypes(){
        return DaoFactory.getTrainingProgramTypeDao().getTrainingProgramTypes();
    }
}
