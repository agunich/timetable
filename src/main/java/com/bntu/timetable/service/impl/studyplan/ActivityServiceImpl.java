package com.bntu.timetable.service.impl.studyplan;

import com.bntu.timetable.entity.studyplan.schedule.Activity;
import com.bntu.timetable.repository.studyplan.ActivityRepository;
import com.bntu.timetable.service.api.studyplan.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public Activity getActivity(UUID id) {
        return activityRepository.findById(id).orElse(null);
    }

    @Override
    public List<Activity> getActivities() {
        return activityRepository.findAll();
    }

    @Override
    public Activity createActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    @Override
    public Activity updateActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    @Override
    public void deleteActivity(UUID id) {
        activityRepository.deleteById(id);
    }
}
