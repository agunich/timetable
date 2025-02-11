package com.bntu.timetable.repository.teacher;

import com.bntu.timetable.entity.teacher.AcademicTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AcademicTitleRepository extends JpaRepository<AcademicTitle, UUID> {
}
