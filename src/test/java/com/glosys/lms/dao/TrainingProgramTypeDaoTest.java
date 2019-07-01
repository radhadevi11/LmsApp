package com.glosys.lms.dao;

import com.glosys.lms.TrainingProgramType;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TrainingProgramTypeDaoTest {
    public static void main(String[] args) {
        TrainingProgramTypeDao trainingProgramTypeDao = new TrainingProgramTypeDao();
        List<TrainingProgramType> typeList = trainingProgramTypeDao.getTrainingProgramTypes();
        for (TrainingProgramType trainingProgramType : typeList){
            System.out.println(trainingProgramType.getName());
        }
    }

}