package com.bntu.timetable.service.api.studyplan;

import com.bntu.timetable.entity.studyplan.schedule.Activity;

import java.util.List;
import java.util.UUID;

public interface ActivityService {

    Activity getActivity(UUID id);

    List<Activity> getActivities();

    Activity createActivity(Activity activity);

    Activity updateActivity(Activity activity);

    void deleteActivity(UUID id);


}
