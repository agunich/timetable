package com.bntu.timetable.service.api;

import com.bntu.timetable.entity.University;

import java.util.List;
import java.util.UUID;

public interface UniversityService {

    University getUniversity(UUID id);

    List<University> getUniversities();

    University createUniversity(University university);

    University updateUniversity(University university);

    void deleteUniversity(UUID id);
}
