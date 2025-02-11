package com.bntu.timetable.service.api.studyplan;

import com.bntu.timetable.entity.studyplan.structure.Component;

import java.util.List;
import java.util.UUID;

public interface ComponentService {

    Component getComponent(UUID id);

    List<Component> getComponents();

    Component createComponent(Component component);

    Component updateComponent(Component component);

    void deleteComponent(UUID id);

}
