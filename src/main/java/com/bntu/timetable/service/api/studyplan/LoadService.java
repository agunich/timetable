package com.bntu.timetable.service.api.studyplan;

import com.bntu.timetable.entity.studyplan.structure.Load;

import java.util.List;
import java.util.UUID;

public interface LoadService {

    Load getLoad(UUID id);

    List<Load> getLoads();

    Load createLoad(Load load);

    Load updateLoad(Load load);

    void deleteLoad(UUID id);
}
