package com.bntu.timetable.repository.discipline;

import com.bntu.timetable.entity.studyplan.structure.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, UUID> {
    List<Discipline> findAllByIsTemplate(boolean isTemplate);
}
