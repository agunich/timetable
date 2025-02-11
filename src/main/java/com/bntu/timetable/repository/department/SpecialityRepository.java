package com.bntu.timetable.repository.department;

import com.bntu.timetable.entity.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, UUID> {
    List<Speciality> findAllByDepartment_Id(UUID departmentId);

    List<Speciality> findAllByDepartment_Deanery_id(UUID deaneryId);

}
