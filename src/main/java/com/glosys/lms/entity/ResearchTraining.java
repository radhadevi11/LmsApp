package com.glosys.lms.entity;

import javax.persistence.*;

@Entity
@Table(name = "research_training")

public class ResearchTraining {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "research_training_id")
    private Integer id ;

    @Column(name = "duration")
    private String duration;

    @Column (name = "cost")
    private double cost;

    @Column(name = "no_of_courses ")
    private int noOfCourses;

    @Column(name = "mode_of_training")
    private String modeOfTraining;

    @Column(name = "training_program_type_id")
    @Enumerated
    private TrainingProgramTypeEnum trainingProgramType;

    public ResearchTraining() {

    }


    public ResearchTraining(String duration, double cost, int noOfCourses, String modeOfTraining, TrainingProgramTypeEnum trainingProgramType) {
        this(null,duration, cost, noOfCourses , modeOfTraining, trainingProgramType);
    }

    public ResearchTraining(Integer id, String duration, double cost, int noOfCourses, String modeOfTraining,
                            TrainingProgramTypeEnum trainingProgramType) {
        this.id = id;
        this.duration = duration;
        this.cost = cost;
        this.noOfCourses = noOfCourses;
        this.modeOfTraining = modeOfTraining;
        this.trainingProgramType = trainingProgramType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getNoOfCourses() {
        return noOfCourses;
    }

    public void setNoOfCourses(int noOfCourses) {
        this.noOfCourses = noOfCourses;
    }

    public String getModeOfTraining() {
        return modeOfTraining;
    }

    public void setModeOfTraining(String modeOfTraining) {
        this.modeOfTraining = modeOfTraining;
    }

    public TrainingProgramTypeEnum getTrainingProgramType() {
        return trainingProgramType;
    }

    public void setTrainingProgramType(TrainingProgramTypeEnum trainingProgramType) {
        this.trainingProgramType = trainingProgramType;
    }
}
