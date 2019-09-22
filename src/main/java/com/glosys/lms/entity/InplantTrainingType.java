package com.glosys.lms.entity;

import javax.persistence.*;

@Entity
@Table(name = "inplant_training_type")

public class InplantTrainingType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inplant_training_type_id")
    private Integer id;

    @Column(name = " mode_of_training")
    private String modeOfTraining;

    @Column(name = "no_of_programs ")
    private int noOfPrograms;

    @Column(name = "total_days")
    private int totalDays;

    @Column (name = "total_hours" )
    private int totalHours;

    @Column(name = "hours_per_day")
    private int hoursPerDay;

    @Column(name = "package")
    private String inplantPackage;

    @Column(name = "cost")
    private double cost;

    public InplantTrainingType() {

    }

    public InplantTrainingType(String modeOfTraining, int noOfPrograms, int totalDays, int totalHours,
                               int hoursPerDay, String inplantPackage, double cost) {
        this.modeOfTraining = modeOfTraining;
        this.noOfPrograms = noOfPrograms;
        this.totalDays = totalDays;
        this.totalHours = totalHours;
        this.hoursPerDay = hoursPerDay;
        this.inplantPackage = inplantPackage;
        this.cost = cost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModeOfTraining() {
        return modeOfTraining;
    }

    public void setModeOfTraining(String modeOfTraining) {
        this.modeOfTraining = modeOfTraining;
    }

    public int getNoOfPrograms() {
        return noOfPrograms;
    }

    public void setNoOfPrograms(int noOfPrograms) {
        this.noOfPrograms = noOfPrograms;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(int totalHours) {
        this.totalHours = totalHours;
    }

    public int getHoursPerDay() {
        return hoursPerDay;
    }

    public void setHoursPerDay(int hoursPerDay) {
        this.hoursPerDay = hoursPerDay;
    }

    public String getInplantPackage() {
        return inplantPackage;
    }

    public void setInplantPackage(String inplantPackage) {
        this.inplantPackage = inplantPackage;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "InplantTrainingType{" +
                "id=" + id +
                ", modeOfTraining='" + modeOfTraining + '\'' +
                ", noOfPrograms=" + noOfPrograms +
                ", totalDays=" + totalDays +
                ", totalHours=" + totalHours +
                ", hoursPerDay=" + hoursPerDay +
                ", inplantPackage='" + inplantPackage + '\'' +
                ", cost=" + cost +
                '}';
    }
}
