package com.bntu.timetable.dto.timetable;

import com.bntu.timetable.entity.Deanery;
import com.bntu.timetable.entity.Flow;
import com.bntu.timetable.entity.studyplan.StudyPlan;
import com.bntu.timetable.entity.timetable.Shift;
import lombok.Data;

import java.util.List;

@Data
public class TimetableDialogCreateCommonInfo {
    private Deanery deanery;
    private List<Flow> flows;
    private List<StudyPlan> studyPlans;
    private List<Shift> shifts;
}
