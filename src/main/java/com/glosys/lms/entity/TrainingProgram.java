package com.glosys.lms.entity;

import java.time.LocalDate;

public interface TrainingProgram extends Comparable<TrainingProgram> {

    LocalDate getStartDate();
    @Override
    default int compareTo(TrainingProgram trainingProgram){
        return this.getStartDate().compareTo(trainingProgram.getStartDate());
    }

    TrainingProgramTypeEnum getTrainingProgramType();

    String getDuration();
}
