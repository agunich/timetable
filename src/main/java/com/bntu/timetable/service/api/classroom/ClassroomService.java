package com.bntu.timetable.service.api.classroom;

import com.bntu.timetable.entity.classroom.Classroom;

import java.util.List;
import java.util.UUID;

public interface ClassroomService {

    Classroom createClassroom (Classroom classroom);

    Classroom updateClassroom (Classroom classroom);

    Classroom getClassroom(UUID id);

    void deleteClassroom(UUID id);

    List<Classroom> getClassrooms();

    List<Classroom> getClassroomByDeaneryId(UUID deaneryId);

    List<Classroom> getClassroomByDepartmentId(UUID departmentId);
}
