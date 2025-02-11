package com.bntu.timetable.dto.teacher;

import com.bntu.timetable.entity.teacher.AcademicDegree;
import com.bntu.timetable.entity.teacher.AcademicTitle;
import com.bntu.timetable.entity.teacher.TeacherPosition;
import com.bntu.timetable.entity.teacher.WorkTariff;
import lombok.Data;

import java.util.List;

@Data
public class InfoForTeacherCreation {
    private List<TeacherPosition> teacherPositions;
    private List<AcademicTitle> academicTitles;
    private List<AcademicDegree> academicDegrees;
    private List<WorkTariff> workTariffs;
}
