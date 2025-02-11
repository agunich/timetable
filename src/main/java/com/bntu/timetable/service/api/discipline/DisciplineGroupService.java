package com.bntu.timetable.service.api.discipline;


import com.bntu.timetable.entity.studyplan.structure.DisciplineGroup;

import java.util.List;
import java.util.UUID;

public interface DisciplineGroupService {
    DisciplineGroup getDisciplineGroup(UUID id);

    List<DisciplineGroup> getDisciplineGroups();

    DisciplineGroup createDisciplineGroup(DisciplineGroup disciplineGroup);

    DisciplineGroup updateDisciplineGroup(DisciplineGroup disciplineGroup);

    void deleteDisciplineGroup(UUID id);
}
