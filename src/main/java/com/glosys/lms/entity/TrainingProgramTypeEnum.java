package com.glosys.lms.entity;

public enum TrainingProgramTypeEnum {
    DUMMY(0,"dummy"),
    WORKSHOP(1, "Workshop"),
    INPLANT_TRAINING(2, "Inplant Training"),
    CORPORATE_TRAINING(3, "Corporate Training"),
    RESEARCH_TRAINING(4, "Research Training");

    private int id;
    private String name;


    TrainingProgramTypeEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public static TrainingProgramTypeEnum getTrainingProgram(int id){
        TrainingProgramTypeEnum[] trainingProgramTypeEnums = values();
        for(TrainingProgramTypeEnum trainingProgramTypeEnum : trainingProgramTypeEnums){
           if( trainingProgramTypeEnum.id == id) {
               return trainingProgramTypeEnum;
           }
        }
        throw new IllegalArgumentException("Invalid id");
    }

    public String getName() {
        return name;
    }
}
