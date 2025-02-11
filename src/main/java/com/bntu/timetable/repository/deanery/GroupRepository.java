package com.bntu.timetable.repository.deanery;

import com.bntu.timetable.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GroupRepository extends JpaRepository<Group, UUID> {

    List<Group> findAllBySpeciality_Department_Deanery_Id(UUID deaneryId);

    List<Group> findAllBySpeciality_Department_Id(UUID departmentId);

}
