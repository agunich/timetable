package com.bntu.timetable.service.api.deanery;

import com.bntu.timetable.entity.Group;

import java.util.List;
import java.util.UUID;

public interface GroupService {

    Group createGroup (Group group);

    Group updateGroup (Group group);

    Group getGroup(UUID id);

    void deleteGroup(UUID id);

    List<Group> getGroups();

    List<Group> getGroupsByDeaneryId(UUID deaneryId);

    List<Group> getGroupsByDepartmentId(UUID departmentId);

    List<Group> getGroupsByFlowId(UUID flowId);
}
