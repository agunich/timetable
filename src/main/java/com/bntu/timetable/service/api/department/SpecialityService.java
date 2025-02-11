package com.bntu.timetable.service.api.department;


import com.bntu.timetable.entity.Speciality;

import java.util.List;
import java.util.UUID;

public interface SpecialityService {

    Speciality createSpeciality (Speciality speciality);

    Speciality updateSpeciality(Speciality speciality);

    Speciality getSpeciality(UUID id);

    void deleteSpeciality(UUID id);

    List<Speciality> getSpecialities();

    List<Speciality> getSpecialitiesByDepartment(UUID departmentId);

    List<Speciality> getSpecialitiesByDeanery(UUID deaneryId);
}
