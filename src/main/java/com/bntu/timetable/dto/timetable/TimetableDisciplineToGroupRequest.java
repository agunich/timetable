package com.bntu.timetable.dto.timetable;

import com.bntu.timetable.entity.Group;
import lombok.Data;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
public class TimetableDisciplineToGroupRequest {
    private Map<UUID, List<Group>> planToGroups;
    private BigInteger targetSemesterNum;
}
