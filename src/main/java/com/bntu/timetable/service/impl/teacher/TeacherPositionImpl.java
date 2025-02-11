package com.bntu.timetable.service.impl.teacher;

import com.bntu.timetable.entity.teacher.TeacherPosition;
import com.bntu.timetable.repository.teacher.TeacherPositionRepository;
import com.bntu.timetable.service.api.teacher.TeacherPositionService;
import com.bntu.timetable.errorhandling.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TeacherPositionImpl implements TeacherPositionService {

    @Autowired
    private TeacherPositionRepository teacherPositionRepository;
    
    @Override
    public TeacherPosition getTeacherPosition(UUID id) {
        return getTeacherPositionById(id);
    }

    @Override
    public List<TeacherPosition> getTeacherPositions() {
        return teacherPositionRepository.findAll();
    }

    @Override
    public TeacherPosition createTeacherPosition(TeacherPosition teacherPosition) {
        return teacherPositionRepository.save(teacherPosition);
    }

    @Override
    public TeacherPosition updateTeacherPosition(TeacherPosition teacherPositionDto) {
        TeacherPosition teacherPosition = getTeacherPosition(teacherPositionDto.getId());
        teacherPosition.setName(teacherPositionDto.getName());

        return teacherPositionRepository.save(teacherPosition);
    }

    @Override
    public void deleteTeacherPosition(UUID id) {
        teacherPositionRepository.deleteById(id);
    }

    private TeacherPosition getTeacherPositionById(UUID id) {
        TeacherPosition teacherPosition = teacherPositionRepository.findById(id).orElse(null);
        if (teacherPosition == null) {
            throw new RuntimeException(ErrorMessage.ACADEMIC_DEGREE_NOT_FOUND);
        }
        return teacherPosition;
    }
}
