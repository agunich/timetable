package com.bntu.timetable.service.api.deanery;

import com.bntu.timetable.entity.Flow;

import java.util.List;
import java.util.UUID;

public interface FlowService {

    Flow createFlow(Flow flow);

    Flow updateFlow(Flow flow);

    Flow getFlow(UUID id);

    void deleteFlow(UUID id);

    List<Flow> getFlows();

    List<Flow> getFlowsByDepartmentId(UUID departmentId);

    List<Flow> getFlowsByDeaneryId(UUID deaneryId);

}
