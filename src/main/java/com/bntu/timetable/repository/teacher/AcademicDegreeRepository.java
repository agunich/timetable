package com.bntu.timetable.repository.teacher;

import com.bntu.timetable.entity.teacher.AcademicDegree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface AcademicDegreeRepository extends JpaRepository<AcademicDegree, UUID> {
}
