package com.bntu.timetable.service.impl.classroom;

import com.bntu.timetable.dto.classroomfund.WingDto;
import com.bntu.timetable.entity.classroom.Wing;
import com.bntu.timetable.errorhandling.ErrorMessage;
import com.bntu.timetable.repository.classroom.FloorRepository;
import com.bntu.timetable.repository.classroom.WingRepository;
import com.bntu.timetable.service.api.classroom.ClassroomService;
import com.bntu.timetable.service.api.util.ImageService;
import com.bntu.timetable.service.api.classroom.WingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.UUID;

@Service
public class WingServiceImpl implements WingService {

    @Autowired
    private WingRepository wingRepository;

    @Autowired
    private ClassroomService classroomService;

    @Autowired
    private FloorRepository floorRepository;

    @Autowired
    private ImageService imageService;

    @Override
    public Wing createWing(WingDto wingDto) {
        Wing wing = new Wing();
        wing.setName(wingDto.getName());
        wing.setFloor(floorRepository.findById(wingDto.getFloorId()).get());
        wing.setPlanImage(wingDto.getPlanImage());
        return wingRepository.save(wing);
    }

    @Override
    public Wing updateWing(WingDto wingDto) {
        Wing wing = getWingById(wingDto.getId());
        wing.setFloor(floorRepository.findById(wingDto.getFloorId()).get());
        return wingRepository.save(wing);
    }

    @Override
    public Wing uploadPlan(UUID id, String plan) throws GeneralSecurityException, IOException {
        Wing wing = getWingById(id);
        wing.setPlanImage(imageService.save(plan));
        return wingRepository.save(wing);
    }

    @Override
    public Wing getWing(UUID id) {
        return getWingById(id);
    }

    @Override
    public Wing getWingByClassroomId(UUID id) {
        return classroomService.getClassroom(id).getWing();
    }

    @Override
    public void deleteWing(UUID id) {
        wingRepository.deleteById(id);
    }

    @Override
    public List<Wing> getWings() {
        return wingRepository.findAll();
    }

    private Wing getWingById(UUID id) {
        Wing wing = wingRepository.findById(id).orElse(null);
        if (wing == null) {
            throw new RuntimeException(ErrorMessage.WING_NOT_FOUND);
        }
        return wing;
    }
}
