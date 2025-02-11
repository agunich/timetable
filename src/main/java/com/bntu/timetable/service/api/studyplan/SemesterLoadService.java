package com.bntu.timetable.service.api.studyplan;


import com.bntu.timetable.entity.studyplan.structure.SemesterLoad;

import java.util.List;
import java.util.UUID;

public interface SemesterLoadService {

    SemesterLoad getSemesterLoad(UUID id);

    List<SemesterLoad> getSemesterLoads();

    SemesterLoad createSemesterLoad(SemesterLoad semesterLoad);

    SemesterLoad updateSemesterLoad(SemesterLoad semesterLoad);

    void deleteSemesterLoad(UUID id);
}
