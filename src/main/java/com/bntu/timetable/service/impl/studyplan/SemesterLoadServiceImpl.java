package com.bntu.timetable.service.impl.studyplan;

import com.bntu.timetable.entity.studyplan.structure.SemesterLoad;
import com.bntu.timetable.errorhandling.ErrorMessage;
import com.bntu.timetable.repository.studyplan.SemesterLoadRepository;
import com.bntu.timetable.service.api.studyplan.SemesterLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SemesterLoadServiceImpl implements SemesterLoadService {

    @Autowired
    private SemesterLoadRepository semesterLoadRepository;

    @Override
    public SemesterLoad getSemesterLoad(UUID id) {
        return getSemesterLoadById(id);
    }

    @Override
    public List<SemesterLoad> getSemesterLoads() {
        return semesterLoadRepository.findAll();
    }

    @Override
    public SemesterLoad createSemesterLoad(SemesterLoad semesterLoad) {
        return semesterLoadRepository.save(semesterLoad);
    }

    @Override
    public SemesterLoad updateSemesterLoad(SemesterLoad semesterLoadDto) {
        SemesterLoad semesterLoad = getSemesterLoad(semesterLoadDto.getId());
        semesterLoad.setName(semesterLoadDto.getName());

        return semesterLoadRepository.save(semesterLoad);
    }

    @Override
    public void deleteSemesterLoad(UUID id) {
        semesterLoadRepository.deleteById(id);
    }

    private SemesterLoad getSemesterLoadById(UUID id) {
        SemesterLoad semesterLoad = semesterLoadRepository.findById(id).orElse(null);
        if (semesterLoad == null) {
            throw new RuntimeException(ErrorMessage.ACADEMIC_DEGREE_NOT_FOUND);
        }
        return semesterLoad;
    }
}
