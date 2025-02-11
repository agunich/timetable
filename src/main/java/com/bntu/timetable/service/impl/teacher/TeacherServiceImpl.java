package com.bntu.timetable.service.impl.teacher;

import com.bntu.timetable.dto.teacher.InfoForTeacherCreation;
import com.bntu.timetable.entity.teacher.Teacher;
import com.bntu.timetable.repository.teacher.TeacherRepository;
import com.bntu.timetable.service.api.teacher.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private AcademicTitleService academicTitleService;

    @Autowired
    private AcademicDegreeService academicDegreeService;

    @Autowired
    private WorkTariffService workTariffService;

    @Autowired
    private TeacherPositionService teacherPositionService;


    @Override
    public Teacher getTeacher(UUID id) {
        return teacherRepository.findById(id).orElse(null);
    }

    @Override
    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacher(UUID id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public InfoForTeacherCreation loadDataForTeacherCreation() {
        InfoForTeacherCreation info = new InfoForTeacherCreation();
        info.setAcademicDegrees(academicDegreeService.getAcademicDegrees());
        info.setAcademicTitles(academicTitleService.getAcademicTitles());
        info.setTeacherPositions(teacherPositionService.getTeacherPositions());
        info.setWorkTariffs(workTariffService.getWorkTariffs());
        return info;
    }
}
