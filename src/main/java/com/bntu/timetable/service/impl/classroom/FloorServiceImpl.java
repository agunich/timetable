package com.bntu.timetable.service.impl.classroom;

import com.bntu.timetable.entity.classroom.Floor;
import com.bntu.timetable.errorhandling.ErrorMessage;
import com.bntu.timetable.repository.classroom.FloorRepository;
import com.bntu.timetable.service.api.classroom.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FloorServiceImpl implements FloorService {
    @Autowired
    private FloorRepository floorRepository;

    @Override
    public Floor createFloor(Floor floor) {
        return floorRepository.save(floor);
    }

    @Override
    public Floor updateFloor(Floor floor) {
        return floorRepository.save(floor);
    }

    @Override
    public Floor getFloor(UUID id) {
        return getFloorById(id);
    }

    @Override
    public void deleteFloor(UUID id) {
        floorRepository.deleteById(id);
    }

    @Override
    public List<Floor> getFloors() {
        return floorRepository.findAll();
    }

    private Floor getFloorById(UUID id) {
        Floor floor = floorRepository.findById(id).orElse(null);
        if (floor == null) {
            throw new RuntimeException(ErrorMessage.FLOOR_NOT_FOUND);
        }
        return floor;
    }
}
