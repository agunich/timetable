package com.bntu.timetable.dto;

import com.bntu.timetable.entity.Qualification;
import com.bntu.timetable.entity.Speciality;
import com.bntu.timetable.entity.studyplan.schedule.Activity;
import com.bntu.timetable.entity.studyplan.structure.Discipline;
import lombok.Data;

import java.util.List;

@Data
public class CommonInfoForStudyPlan {
    private List<Speciality> specialities;
    private List<Qualification> qualifications;
    private List<Activity> activities;
    private List<Discipline> disciplines;
}
