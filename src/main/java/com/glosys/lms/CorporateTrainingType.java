package com.glosys.lms;

import javax.persistence.*;

@Entity
@Table(name = "corporate_training_type")
public class CorporateTrainingType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "corporate_training_type_id")
    private Integer id;

    @Column(name = "mode_of_training")
    private String modeOfTraining;

    @Column(name = "no_of_certification_courses ")
    private int noOfCertificationCourses;

    @Column(name = "total_days")
    private int totalDays;

    @Column (name = "total_hours" )
    private int totalHours;

    @Column(name = "hours_per_day")
    private int hoursPerDay;

    @Column(name = "package")
    private String corporatePackage;

    @Column(name = "cost")
    private double cost;

    public CorporateTrainingType() {
    }

    public CorporateTrainingType(String modeOfTraining, int noOfCertificationCourses, int totalDays, int totalHours,
                                 int hoursPerDay, String corporatePackage, double cost) {
        this.modeOfTraining = modeOfTraining;
        this.noOfCertificationCourses = noOfCertificationCourses;
        this.totalDays = totalDays;
        this.totalHours = totalHours;
        this.hoursPerDay = hoursPerDay;
        this.corporatePackage = corporatePackage;
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

    public int getNoOfCertificationCourses() {
        return noOfCertificationCourses;
    }

    public void setNoOfCertificationCourses(int noOfCertificationCourses) {
        this.noOfCertificationCourses = noOfCertificationCourses;
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

    public String getCorporatePackage() {
        return corporatePackage;
    }

    public void setCorporatePackage(String corporatePackage) {
        this.corporatePackage = corporatePackage;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "CorporateProgramType{" +
                "id=" + id +
                ", modeOfTraining='" + modeOfTraining + '\'' +
                ", noOfCertificationCourses=" + noOfCertificationCourses +
                ", totalDays=" + totalDays +
                ", totalHours=" + totalHours +
                ", hoursPerDay=" + hoursPerDay +
                ", corporatePackage='" + corporatePackage + '\'' +
                ", cost=" + cost +
                '}';
    }
}
