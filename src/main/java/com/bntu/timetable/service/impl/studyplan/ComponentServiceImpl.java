package com.bntu.timetable.service.impl.studyplan;

import com.bntu.timetable.entity.studyplan.structure.Component;
import com.bntu.timetable.service.api.studyplan.ComponentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ComponentServiceImpl implements ComponentService {

    @Override
    public Component getComponent(UUID id) {
        return null;
    }

    @Override
    public List<Component> getComponents() {
        return null;
    }

    @Override
    public Component createComponent(Component component) {
        return null;
    }

    @Override
    public Component updateComponent(Component component) {
        return null;
    }

    @Override
    public void deleteComponent(UUID id) {

    }
}
