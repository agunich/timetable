package com.bntu.timetable.dto.classroomfund;

import com.bntu.timetable.entity.classroom.Classroom;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class WingDto {

    private UUID id;

    private String name;

    private List<Classroom> classrooms;

    private UUID floorId;

    private String planImage;

}
