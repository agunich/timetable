package com.bntu.timetable.service.impl.studyplan;

import com.bntu.timetable.entity.studyplan.structure.Load;
import com.bntu.timetable.errorhandling.ErrorMessage;
import com.bntu.timetable.repository.studyplan.LoadRepository;
import com.bntu.timetable.service.api.studyplan.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LoadServiceImpl implements LoadService {

    @Autowired
    private LoadRepository loadRepository;

    @Override
    public Load getLoad(UUID id) {
        return getLoadById(id);
    }

    @Override
    public List<Load> getLoads() {
        return loadRepository.findAll();
    }

    @Override
    public Load createLoad(Load load) {
        return loadRepository.save(load);
    }

    @Override
    public Load updateLoad(Load loadDto) {
        Load load = getLoad(loadDto.getId());
        load.setName(loadDto.getName());

        return loadRepository.save(load);
    }

    @Override
    public void deleteLoad(UUID id) {
        loadRepository.deleteById(id);
    }

    private Load getLoadById(UUID id) {
        Load load = loadRepository.findById(id).orElse(null);
        if (load == null) {
            throw new RuntimeException(ErrorMessage.ACADEMIC_DEGREE_NOT_FOUND);
        }
        return load;
    }
}
