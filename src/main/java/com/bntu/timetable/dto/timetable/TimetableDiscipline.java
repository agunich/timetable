package com.bntu.timetable.dto.timetable;

import com.bntu.timetable.entity.studyplan.structure.Discipline;
import lombok.Data;

@Data
public class TimetableDiscipline {
    private Discipline discipline;
    private Double classroomHours;
}
