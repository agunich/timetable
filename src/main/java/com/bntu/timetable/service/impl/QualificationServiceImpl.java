package com.bntu.timetable.service.impl;

import com.bntu.timetable.entity.Qualification;
import com.bntu.timetable.repository.QualificationRepository;
import com.bntu.timetable.service.api.QualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QualificationServiceImpl implements QualificationService {

    @Autowired
    private QualificationRepository qualificationRepository;

    @Override
    public List<Qualification> getQualifications() {
        return qualificationRepository.findAll();
    }
}
