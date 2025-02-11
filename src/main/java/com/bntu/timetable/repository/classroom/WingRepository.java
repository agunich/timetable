package com.bntu.timetable.repository.classroom;

import com.bntu.timetable.entity.classroom.Wing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface WingRepository  extends JpaRepository<Wing, UUID> {

    void deleteAllWingByFloor_Id(UUID floorId);

    List<Wing> getAllByFloor_Id(UUID floorId);
}
