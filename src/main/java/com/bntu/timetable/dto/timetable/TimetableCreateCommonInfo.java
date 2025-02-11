package com.bntu.timetable.dto.timetable;


import com.bntu.timetable.entity.classroom.Building;

import com.bntu.timetable.entity.teacher.Teacher;

import lombok.Data;

import java.util.List;

@Data
public class TimetableCreateCommonInfo {
    private List<Building> buildings;
    private List<Teacher> teachers;

}
