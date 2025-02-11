package com.bntu.timetable.repository.deanery;

import com.bntu.timetable.entity.Deanery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DeaneryRepository extends JpaRepository<Deanery, UUID> {
}
