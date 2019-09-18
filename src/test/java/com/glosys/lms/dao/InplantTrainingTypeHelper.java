package com.glosys.lms.dao;

import com.glosys.lms.entity.InplantTraining;
import com.glosys.lms.entity.InplantTrainingType;

import javax.persistence.EntityManager;

public class InplantTrainingTypeHelper {
    public InplantTrainingType save(EntityManager em){
        InplantTrainingTypeDao inplantTrainingTypeDao = new InplantTrainingTypeDao(em);
        return inplantTrainingTypeDao.save(new InplantTrainingType("class room", 2, 2, 2, 2, null, 2 ));
    }
}
