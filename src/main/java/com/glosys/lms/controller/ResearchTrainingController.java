package com.glosys.lms.controller;

import com.glosys.lms.model.ResearchTrainingInfo;
import service.ResearchTrainingService;

public class ResearchTrainingController {
    public static ResearchTrainingService researchTrainingService = new ResearchTrainingService();

    public ResearchTrainingInfo getResearchTrainingInfo(){
        return new ResearchTrainingInfo(researchTrainingService.getResearchTrainings(),
                researchTrainingService.getCoursesForResearchTraining());
    }
}
