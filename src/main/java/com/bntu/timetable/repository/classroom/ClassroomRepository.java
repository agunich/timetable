package com.bntu.timetable.repository.classroom;

import com.bntu.timetable.entity.classroom.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, UUID> {

    void deleteAllByWing_Id(UUID wingId);

    List<Classroom> getAllByWing_id (UUID wingId);

    List<Classroom> getAllByDeanery_Id(UUID deaneryId);

    List<Classroom> getAllByDepartment_Id(UUID departmentId);

}
