package com.bntu.timetable.repository.department;

import com.bntu.timetable.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, UUID> {

    List<Department> findAllByDeanery_Id(UUID deaneryId);

}
