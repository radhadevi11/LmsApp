package com.glosys.lms;

import javax.persistence.*;


@Entity
@Table(name = "workshop")
public class Workshop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workshop_id")
    private Integer id;
    @Column(name = "mode_of_training")
    private String modeOfTraining;
    @Column(name = "no_of_workshops")
    private int noOfWorkShops;
    @Column(name = "total_days")
    private int totalDays;
    @Column(name = "total_hours")
    private int totalHours;
    @Column(name = "hours_per_day")
    private int hoursPerDay;
    @Column(name = "package_type")
    private String packageType;
    @Column(name = "cost")
    private int cost;

    public Workshop(){
    }

    public Workshop(String modeOfTraining, int noOfWorkShops, int totalDays, int totalHours, int hoursPerDay, String packageType, int cost) {
        this.modeOfTraining = modeOfTraining;
        this.noOfWorkShops = noOfWorkShops;
        this.totalDays = totalDays;
        this.totalHours = totalHours;
        this.hoursPerDay = hoursPerDay;
        this.packageType = packageType;
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



    public int getNoOfWorkShops() {
        return noOfWorkShops;
    }

    public void setNoOfWorkShops(int noOfWorkShops) {
        this.noOfWorkShops = noOfWorkShops;
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

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString(){
        return "modeOfTraining "+this.modeOfTraining+"\n"+"totalDays "+this.totalDays+"\n"+"totalCost "+this.cost ;
    }






}
