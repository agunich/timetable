package com.bntu.timetable.repository.discipline;

import com.bntu.timetable.entity.studyplan.structure.DisciplineGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DisciplineGroupRepository extends JpaRepository<DisciplineGroup, UUID> {
}
