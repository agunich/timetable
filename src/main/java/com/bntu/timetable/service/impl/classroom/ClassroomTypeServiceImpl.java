package com.bntu.timetable.service.impl.classroom;

import com.bntu.timetable.entity.classroom.ClassroomType;
import com.bntu.timetable.errorhandling.ErrorMessage;
import com.bntu.timetable.repository.classroom.ClassroomTypeRepository;
import com.bntu.timetable.service.api.classroom.ClassroomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClassroomTypeServiceImpl implements ClassroomTypeService {
    @Autowired
    private ClassroomTypeRepository classroomTypeRepository;

    @Override
    public ClassroomType createClassroomType(ClassroomType classroomType) {
        return classroomTypeRepository.save(classroomType);
    }

    @Override
    public ClassroomType updateClassroomType(ClassroomType classroomType) {
        return classroomTypeRepository.save(classroomType);
    }

    @Override
    public ClassroomType getClassroomType(UUID id) {
        return getClassroomTypeById(id);
    }

    @Override
    public void deleteClassroomType(UUID id) {
        classroomTypeRepository.deleteById(id);
    }

    @Override
    public List<ClassroomType> getClassroomTypes() {
        return classroomTypeRepository.findAll();
    }


    private ClassroomType getClassroomTypeById(UUID id) {
        ClassroomType classroomType = classroomTypeRepository.findById(id).orElse(null);
        if (classroomType == null) {
            throw new RuntimeException(ErrorMessage.CLASSROOM_TYPE_NOT_FOUND);
        }
        return classroomType;
    }

}
