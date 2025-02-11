package com.bntu.timetable.service.api.studyplan;

import com.bntu.timetable.dto.CommonInfoForStudyPlan;
import com.bntu.timetable.entity.studyplan.StudyPlan;
import com.bntu.timetable.entity.studyplan.StudyPlanStatus;

import java.util.List;
import java.util.UUID;

public interface StudyPlanService {

    StudyPlan getStudyPlan(UUID id);

    List<StudyPlan> getStudyPlans();

    List<StudyPlan> getStudyPlans(boolean isStandard);

    StudyPlan createStudyPlan(StudyPlan studyPlan);

    StudyPlan updateStudyPlan(StudyPlan studyPlan);

    void deleteStudyPlan(UUID id);

    CommonInfoForStudyPlan loadCommonInfo();

    StudyPlan changeStudyPlanStatus(UUID id, StudyPlanStatus status);

    StudyPlan registerStudyPlan(UUID id, String registerNumber);

    List<StudyPlan> getStudyPlansByDeaneryId(UUID deaneryId);
}
