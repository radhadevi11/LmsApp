package com.glosys.lms.dao;

import com.glosys.lms.entity.ResearchTraining;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ResearchTrainingDaoTest2 {

    @Test
    public void testGetResearchTrainings(){
        ResearchTrainingDao researchTrainingDao = new ResearchTrainingDao();
        List<ResearchTraining> actual = researchTrainingDao.getResearchTrainings();
        assertEquals(2, actual.size());
    }

}