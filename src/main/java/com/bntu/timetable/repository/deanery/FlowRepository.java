package com.bntu.timetable.repository.deanery;

import com.bntu.timetable.entity.Flow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface FlowRepository extends JpaRepository<Flow, UUID> {
    List<Flow> getAllByDeanery_Id(UUID deaneryId);

    @Query(value = "select distinct flow.* from flow join flow_groups sg on flow.id = sg.flow_id\n" +
            "where sg.group_id in\n" +
            "      (select id from study_group sgg where sgg.speciality_id in\n" +
            "                                        (select id from speciality s where s.department_id =?1));\n" +
            "\n", nativeQuery = true)
    List<Flow> getFlowsByDepartmentId(UUID departmentId);

}
