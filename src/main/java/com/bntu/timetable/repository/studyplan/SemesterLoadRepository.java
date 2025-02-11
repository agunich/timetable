package com.bntu.timetable.repository.studyplan;

import com.bntu.timetable.entity.studyplan.structure.SemesterLoad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SemesterLoadRepository extends JpaRepository<SemesterLoad, UUID> {
}
