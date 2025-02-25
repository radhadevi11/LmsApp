package com.glosys.lms.dao;

import com.glosys.lms.entity.Trainer;
import com.glosys.lms.entity.Workshop;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class WorkshopHelper {
    public Workshop save(EntityManager em, LocalDate workshopDate) {
        return save(em, workshopDate, new TrainerHelper().save(em, "some name"));
    }

    public Workshop save(EntityManager em, LocalDate workshopDate, Trainer trainer) {
        Workshop workshop = new Workshop(new WorkshopTypeHelper().save(em), new CourseHelper().save(em), workshopDate,
                trainer, null);
        return new WorkshopDao(em).save(workshop);
    }


}
