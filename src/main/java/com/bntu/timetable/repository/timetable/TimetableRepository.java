package com.bntu.timetable.repository.timetable;

import com.bntu.timetable.entity.timetable.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TimetableRepository extends JpaRepository<Timetable, UUID> {
//    List<Timetable> findAllBy
}
