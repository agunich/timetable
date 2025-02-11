package com.bntu.timetable.repository.studyplan;

import com.bntu.timetable.entity.studyplan.structure.Component;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ComponentRepository extends JpaRepository<Component, UUID> {
}
