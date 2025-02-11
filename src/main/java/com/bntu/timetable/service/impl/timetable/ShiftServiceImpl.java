package com.bntu.timetable.service.impl.timetable;

import com.bntu.timetable.entity.timetable.Shift;

import com.bntu.timetable.repository.timetable.ShiftRepository;
import com.bntu.timetable.service.api.timetable.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ShiftServiceImpl implements ShiftService {

    @Autowired
    private ShiftRepository shiftRepository;

    @Override
    public List<Shift> getShifts() {
        return shiftRepository.findAll();
    }
}
