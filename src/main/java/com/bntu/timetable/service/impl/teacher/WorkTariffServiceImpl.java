package com.bntu.timetable.service.impl.teacher;

import com.bntu.timetable.entity.teacher.WorkTariff;
import com.bntu.timetable.repository.teacher.WorkTariffRepository;
import com.bntu.timetable.service.api.teacher.WorkTariffService;
import com.bntu.timetable.errorhandling.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WorkTariffServiceImpl implements WorkTariffService {

    @Autowired
    private WorkTariffRepository workTariffRepository;

    @Override
    public WorkTariff getWorkTariff(UUID id) {
        return getWorkTariffById(id);
    }

    @Override
    public List<WorkTariff> getWorkTariffs() {
        return workTariffRepository.findAll();
    }

    @Override
    public WorkTariff createWorkTariff(WorkTariff workTariff) {
        return workTariffRepository.save(workTariff);
    }

    @Override
    public WorkTariff updateWorkTariff(WorkTariff workTariffDto) {
        WorkTariff workTariff = getWorkTariff(workTariffDto.getId());
        workTariff.setName(workTariffDto.getName());

        return workTariffRepository.save(workTariff);
    }

    @Override
    public void deleteWorkTariff(UUID id) {
        workTariffRepository.deleteById(id);
    }

    private WorkTariff getWorkTariffById(UUID id) {
        WorkTariff workTariff = workTariffRepository.findById(id).orElse(null);
        if (workTariff == null) {
            throw new RuntimeException(ErrorMessage.ACADEMIC_DEGREE_NOT_FOUND);
        }
        return workTariff;
    }
}
