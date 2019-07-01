package com.glosys.lms;

import javax.persistence.*;
@Table(name = "workshop_type")
@Entity
public class WorkshopType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workshop_type_id")
    private Integer id;

    @Column(name = " mode_of_training")
    private String modeOfTraining;

    @Column(name = "no_of_workshops ")
    private int noOfWorkshops;

    @Column(name = "total_days")
    private int totalDays;

    @Column (name = "total_hours" )
    private int totalHours;

    @Column(name = "hours_per_day")
    private int hoursPerDay;

    @Column(name = "package")
    private String workshopPackage;

    @Column(name = "cost")
    private double cost;

    public WorkshopType() {
    }

    public WorkshopType(String modeOfTraining, int noOfWorkshops, int totalDays,
                        int totalHours, int hoursPerDay, String workshopPackage, double cost) {
        this.modeOfTraining = modeOfTraining;
        this.noOfWorkshops = noOfWorkshops;
        this.totalDays = totalDays;
        this.totalHours = totalHours;
        this.hoursPerDay = hoursPerDay;
        this.workshopPackage = workshopPackage;
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

    public int getNoOfWorkshops() {
        return noOfWorkshops;
    }

    public void setNoOfWorkshops(int noOfWorkshops) {
        this.noOfWorkshops = noOfWorkshops;
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

    public String getWorkshopPackage() {
        return workshopPackage;
    }

    public void setWorkshopPackage(String workshopPackage) {
        this.workshopPackage = workshopPackage;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "WorkshopType{" +
                "id=" + id +
                ", modeOfTraining='" + modeOfTraining + '\'' +
                ", noOfWorkshops=" + noOfWorkshops +
                ", totalDays=" + totalDays +
                ", totalHours=" + totalHours +
                ", hoursPerDay=" + hoursPerDay +
                ", workshopPackage='" + workshopPackage + '\'' +
                ", cost=" + cost +
                '}';
    }
}

