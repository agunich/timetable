package com.bntu.timetable.dto.classroomfund;

import lombok.Data;

@Data
public class BuildingCreateRequest {
    private String number;
    private int floorsNumber;
    private String description;
}
