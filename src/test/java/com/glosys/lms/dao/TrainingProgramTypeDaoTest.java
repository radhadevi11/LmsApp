package com.glosys.lms.dao;

import com.glosys.lms.entity.TrainingProgramType;

import java.util.List;

public class TrainingProgramTypeDaoTest {
    public static void main(String[] args) {
        TrainingProgramTypeDao trainingProgramTypeDao = new TrainingProgramTypeDao();
        List<TrainingProgramType> typeList = trainingProgramTypeDao.getTrainingProgramTypes();
        for (TrainingProgramType trainingProgramType : typeList){
            System.out.println(trainingProgramType.getName());
        }
    }

}