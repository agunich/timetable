package com.bntu.timetable.service.impl.department;

import com.bntu.timetable.entity.Speciality;
import com.bntu.timetable.errorhandling.ErrorMessage;
import com.bntu.timetable.repository.department.SpecialityRepository;
import com.bntu.timetable.service.api.department.DepartmentService;
import com.bntu.timetable.service.api.department.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class SpecialityServiceImpl implements SpecialityService {

    @Autowired
    private SpecialityRepository specialityRepository;

    @Autowired
    private DepartmentService departmentService;

    @Override
    @Transactional
    public Speciality createSpeciality(Speciality speciality) {
        return specialityRepository.save(speciality);
    }

    @Override
    public Speciality updateSpeciality(Speciality specialityDto) {
        return specialityRepository.save(specialityDto);
    }


    @Override
    public Speciality getSpeciality(UUID id) {
        return getSpecialityById(id);
    }


    private Speciality getSpecialityById(UUID id) {
        Speciality speciality = specialityRepository.findById(id).orElse(null);
        if (speciality == null) {
            throw new RuntimeException(ErrorMessage.GROUP_NOT_FOUND);
        }
        return speciality;
    }

    @Override
    public void deleteSpeciality(UUID id) {
        specialityRepository.deleteById(id);
    }

    @Override
    public List<Speciality> getSpecialities() {
        return specialityRepository.findAll();
    }

    @Override
    public List<Speciality> getSpecialitiesByDepartment(UUID departmentId) {
        return specialityRepository.findAllByDepartment_Id(departmentId);
    }

    @Override
    public List<Speciality> getSpecialitiesByDeanery(UUID departmentId) {
        return specialityRepository.findAllByDepartment_Deanery_id(departmentId);
    }
}
