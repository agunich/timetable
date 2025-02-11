package com.bntu.timetable.repository.classroom;

import com.bntu.timetable.entity.classroom.ClassroomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClassroomTypeRepository extends JpaRepository<ClassroomType, UUID> {
}
