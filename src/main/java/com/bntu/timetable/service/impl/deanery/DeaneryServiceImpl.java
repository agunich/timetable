package com.bntu.timetable.service.impl.deanery;

import com.bntu.timetable.entity.Deanery;
import com.bntu.timetable.errorhandling.ErrorMessage;
import com.bntu.timetable.repository.deanery.DeaneryRepository;
import com.bntu.timetable.service.api.deanery.DeaneryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DeaneryServiceImpl implements DeaneryService {

    @Autowired
    private DeaneryRepository deaneryRepository;

    @Override
    public Deanery createDeanery(Deanery deanery) {
        return deaneryRepository.save(deanery);
    }

    @Override
    public Deanery updateDeanery(Deanery deaneryDto) {
        Deanery deanery = getDeaneryById(deaneryDto.getId());
        deanery.setFullName(deaneryDto.getFullName());
        deanery.setShortName(deaneryDto.getShortName());
        deanery.setDescription(deaneryDto.getDescription());
        deanery.setDepartments(deaneryDto.getDepartments());
        deanery.setFlows(deaneryDto.getFlows());
        return deaneryRepository.save(deanery);
    }

    @Override
    public Deanery getDeanery(UUID id) {
        return getDeaneryById(id);
    }

    private Deanery getDeaneryById(UUID id) {
        Deanery deanery = deaneryRepository.findById(id).orElse(null);
        if (deanery == null) {
            throw new RuntimeException(ErrorMessage.DEANERY_NOT_FOUND);
        }
        return deanery;
    }

    @Override
    public void deleteDeanery(UUID id) {
        deaneryRepository.deleteById(id);
    }

    @Override
    public List<Deanery> getDeaneries() {
        return deaneryRepository.findAll();
    }
}
