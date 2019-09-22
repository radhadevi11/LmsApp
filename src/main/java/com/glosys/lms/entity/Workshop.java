package com.glosys.lms.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "workshop")
public class Workshop implements TrainingProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workshop_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "workshop_type_id")
    private WorkshopType workshopType;
    
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name="workshop_date")
    private LocalDate date;

    @OneToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;



    @Column(name = "material_path")
    private String materialPath;


    public Workshop() {
    }

    public Workshop(WorkshopType workshopType, Course course, LocalDate date, Trainer trainer) {
        this.workshopType = workshopType;
        this.course = course;
        this.date = date;
        this.trainer = trainer;
    }

    public Workshop(WorkshopType workshopType, Course course, LocalDate date, Trainer trainer, String materialPath) {
        this(null, workshopType, course, date, trainer, materialPath);
    }

    public Workshop(Integer id, WorkshopType workshopType, Course course, LocalDate date, Trainer trainer, String materialPath) {
        this.id = id;
        this.workshopType = workshopType;
        this.course = course;
        this.date = date;
        this.trainer = trainer;
        this.materialPath = materialPath;
    }

    public Workshop(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public WorkshopType getWorkshopType() {
        return workshopType;
    }

    public void setWorkshopType(WorkshopType workshopType) {
        this.workshopType = workshopType;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Workshop{" +
                "id=" + id +
                ", workshopType=" + workshopType +
                ", course=" + course +
                ", date=" + date +
                '}';
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    @Override
    public LocalDate getStartDate() {
        return this.date;
    }

    @Override
    public TrainingProgramTypeEnum getTrainingProgramType() {
        return TrainingProgramTypeEnum.WORKSHOP;
    }

    @Override
    public String getDuration() {
        return getWorkshopType().getTotalDays()+" days"+"\n"+getWorkshopType().getHoursPerDay()+" Hours per day";
    }

    @Override
    public double getCost() {
        return getWorkshopType().getCost();
    }

    @Override
    public String getUniquePath() {
        return  String.format("%s_%s_%s_%s_%s",getName(),this.workshopType.getId(), this.course.getId(), this.trainer.getId(), date);
    }


    public String getMaterialPath() {
        return materialPath;
    }

    public void setMaterialPath(String materialPath) {
        this.materialPath = materialPath;
    }
}
