package com.bntu.timetable.service.impl;

import com.bntu.timetable.entity.University;
import com.bntu.timetable.errorhandling.ErrorMessage;
import com.bntu.timetable.repository.UniversityRepository;
import com.bntu.timetable.service.api.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    private UniversityRepository universityRepository;

    @Override
    public University getUniversity(UUID id) {
        return getUniversityById(id);
    }

    @Override
    public List<University> getUniversities() {
        return universityRepository.findAll();
    }

    @Override
    public University createUniversity(University university) {
        return universityRepository.save(university);
    }

    @Override
    public University updateUniversity(University universityDto) {
        University university = getUniversity(universityDto.getId());
        university.setName(universityDto.getName());

        return universityRepository.save(university);
    }

    @Override
    public void deleteUniversity(UUID id) {
        universityRepository.deleteById(id);
    }

    private University getUniversityById(UUID id) {
        University university = universityRepository.findById(id).orElse(null);
        if (university == null) {
            throw new RuntimeException(ErrorMessage.ACADEMIC_DEGREE_NOT_FOUND);
        }
        return university;
    }
}
