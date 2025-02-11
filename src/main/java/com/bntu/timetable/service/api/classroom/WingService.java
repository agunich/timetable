package com.bntu.timetable.service.api.classroom;

import com.bntu.timetable.dto.classroomfund.WingDto;
import com.bntu.timetable.entity.classroom.Wing;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.UUID;

public interface WingService {

    Wing createWing(WingDto wing);

    Wing updateWing(WingDto wingDto);

    Wing uploadPlan(UUID id, String image) throws GeneralSecurityException, IOException;

    Wing getWing(UUID id);

    Wing getWingByClassroomId(UUID id);

    void deleteWing(UUID id);

    List<Wing> getWings();

}
