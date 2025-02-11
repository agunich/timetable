package com.bntu.timetable.service.impl.discipline;

import com.bntu.timetable.entity.studyplan.structure.DisciplineGroup;
import com.bntu.timetable.repository.discipline.DisciplineGroupRepository;
import com.bntu.timetable.service.api.discipline.DisciplineGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DisciplineGroupServiceImpl implements DisciplineGroupService {

    @Autowired
    private DisciplineGroupRepository disciplineGroupRepository;

    @Override
    public DisciplineGroup getDisciplineGroup(UUID id) {
        return disciplineGroupRepository.findById(id).orElse(null);
    }

    @Override
    public List<DisciplineGroup> getDisciplineGroups() {
        return disciplineGroupRepository.findAll();
    }

    @Override
    public DisciplineGroup createDisciplineGroup(DisciplineGroup disciplineGroup) {
        return disciplineGroupRepository.save(disciplineGroup);
    }

    @Override
    public DisciplineGroup updateDisciplineGroup(DisciplineGroup disciplineGroup) {
        return disciplineGroupRepository.save(disciplineGroup);
    }

    @Override
    public void deleteDisciplineGroup(UUID id) {
        disciplineGroupRepository.deleteById(id);
    }
}
