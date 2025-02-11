package com.bntu.timetable.service.impl.teacher;

import com.bntu.timetable.entity.teacher.AcademicDegree;
import com.bntu.timetable.errorhandling.ErrorMessage;
import com.bntu.timetable.repository.teacher.AcademicDegreeRepository;
import com.bntu.timetable.service.api.teacher.AcademicDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AcademicDegreeImpl implements AcademicDegreeService {

    @Autowired
    private AcademicDegreeRepository academicDegreeRepository;

    @Override
    public AcademicDegree getAcademicDegree(UUID id) {
        return  getAcademicDegreeById(id);
    }

    @Override
    public List<AcademicDegree> getAcademicDegrees() {
        return academicDegreeRepository.findAll();
    }

    @Override
    public AcademicDegree createAcademicDegree(AcademicDegree academicDegree) {
        return academicDegreeRepository.save(academicDegree);
    }

    @Override
    public AcademicDegree updateAcademicDegree(AcademicDegree academicDegreeDto) {
        AcademicDegree academicDegree = getAcademicDegree(academicDegreeDto.getId());
        academicDegree.setName(academicDegreeDto.getName());

        return academicDegreeRepository.save(academicDegree);
    }

    @Override
    public void deleteAcademicDegree(UUID id) {
        academicDegreeRepository.deleteById(id);
    }

    private AcademicDegree getAcademicDegreeById(UUID id) {
        AcademicDegree academicDegree = academicDegreeRepository.findById(id).orElse(null);
        if (academicDegree == null) {
            throw new RuntimeException(ErrorMessage.ACADEMIC_DEGREE_NOT_FOUND);
        }
        return academicDegree;
    }
}
