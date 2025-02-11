package com.bntu.timetable.repository.studyplan;

import com.bntu.timetable.entity.studyplan.structure.Load;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoadRepository extends JpaRepository<Load, UUID> {
}
