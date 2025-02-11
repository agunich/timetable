package com.bntu.timetable.service.impl.classroom;

import com.bntu.timetable.entity.classroom.ClassroomSpecialization;
import com.bntu.timetable.errorhandling.ErrorMessage;
import com.bntu.timetable.repository.classroom.ClassroomSpecializationRepository;
import com.bntu.timetable.service.api.classroom.ClassroomSpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClassroomSpecializationImpl implements ClassroomSpecializationService {

    @Autowired
    private ClassroomSpecializationRepository classroomSpecializationRepository;


    @Override
    public ClassroomSpecialization updateClassroomSpecialization(ClassroomSpecialization classroomType) {
        return classroomSpecializationRepository.save(classroomType);
    }

    @Override
    public ClassroomSpecialization getClassroomSpecialization(UUID id) {
        return getClassroomSpecializationById(id);
    }


    @Override
    public List<ClassroomSpecialization> getClassroomSpecializations() {
        return classroomSpecializationRepository.findAll();
    }


    @Override
    public ClassroomSpecialization createClassroomSpecialization(ClassroomSpecialization classroomSpecialization) {
        return null;
    }

    @Override
    public void deleteClassroomSpecialization(UUID id) {

    }

    private ClassroomSpecialization getClassroomSpecializationById(UUID id) {
        ClassroomSpecialization classroomSpecialization = classroomSpecializationRepository.findById(id).orElse(null);
        if (classroomSpecialization == null) {
            throw new RuntimeException(ErrorMessage.CLASSROOM_SPECIALIZATION_NOT_FOUND);
        }
        return classroomSpecialization;
    }


}
