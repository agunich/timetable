package com.bntu.timetable.service.impl.classroom;


import com.bntu.timetable.entity.classroom.Classroom;
import com.bntu.timetable.errorhandling.ErrorMessage;
import com.bntu.timetable.repository.classroom.ClassroomRepository;
import com.bntu.timetable.service.api.classroom.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    private ClassroomRepository classroomRepository;

    @Override
    public Classroom createClassroom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    @Override
    public Classroom updateClassroom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    @Override
    public Classroom getClassroom(UUID id) {
        return getClassroomById(id);
    }

    @Override
    public void deleteClassroom(UUID id) {
        classroomRepository.deleteById(id);
    }

    @Override
    public List<Classroom> getClassrooms() {
        return classroomRepository.findAll();
    }

    @Override
    public List<Classroom> getClassroomByDeaneryId(UUID deaneryId) {
        return classroomRepository.getAllByDeanery_Id(deaneryId);
    }

    @Override
    public List<Classroom> getClassroomByDepartmentId(UUID departmentId) {
        return classroomRepository.getAllByDepartment_Id(departmentId);
    }

    private Classroom getClassroomById(UUID id) {
        Classroom classroom = classroomRepository.findById(id).orElse(null);
        if (classroom == null) {
            throw new RuntimeException(ErrorMessage.CLASSROOM_NOT_FOUND);
        }
        return classroom;
    }
}
