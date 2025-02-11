package com.bntu.timetable.service.api.timetable;


import com.bntu.timetable.dto.timetable.TimetableCreateCommonInfo;
import com.bntu.timetable.dto.timetable.TimetableDialogCreateCommonInfo;
import com.bntu.timetable.dto.timetable.TimetableDiscipline;
import com.bntu.timetable.dto.timetable.TimetableDisciplineToGroupRequest;
import com.bntu.timetable.entity.Group;
import com.bntu.timetable.entity.timetable.Timetable;
import com.bntu.timetable.entity.timetable.TimetableStatus;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface TimetableService {
    Timetable getTimetable(UUID id);

    List<Timetable> getTimetables();

    List<Timetable> getTimetables(UUID deaneryId);

    Timetable createTimetable(Timetable timetable);

    Timetable updateTimetable(Timetable timetable);

    void deleteTimetable(UUID id);

    TimetableDialogCreateCommonInfo loadDialogCreateCommonInfo(UUID deaneryId);

    TimetableCreateCommonInfo loadCreateCommonInfo();

    Map<List<Group>, List<TimetableDiscipline>> loadGroupToDisciplines(TimetableDisciplineToGroupRequest timetableDisciplineToGroupRequest);

    Timetable changeTimetableStatus(UUID id, TimetableStatus status);

}
