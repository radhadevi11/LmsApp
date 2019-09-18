package com.glosys.lms.dao;

import com.glosys.lms.entity.InplantTraining;
import com.glosys.lms.entity.InplantTrainingType;
import com.glosys.lms.entity.Trainer;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class InplantTrainingHelper {
    public InplantTraining save(EntityManager em, LocalDate localDate) {
        return save(em, localDate, new TrainerHelper().save(em, "someTrainer"));
    }

    public InplantTraining save(EntityManager em, LocalDate localDate, Trainer trainer){
        InplantTrainingDao inplantTrainingDao = new InplantTrainingDao(em);
        return inplantTrainingDao.save(new InplantTraining
                (new InplantTrainingTypeHelper().save(em),
                        new CourseHelper().save(em),
                        localDate,
                        trainer));
    }
}
