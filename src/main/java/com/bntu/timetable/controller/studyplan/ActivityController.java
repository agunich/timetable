package com.bntu.timetable.controller.studyplan;

import com.bntu.timetable.entity.studyplan.schedule.Activity;

import com.bntu.timetable.service.api.studyplan.ActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/activities")
@Slf4j
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @GetMapping
    @PreAuthorize("hasAuthority('activities:read')")
    public List<Activity> getActivities() {
        return activityService.getActivities();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('activities:create')")
    public Activity createActivity(@RequestBody Activity activity) {
        return activityService.createActivity(activity);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('activities:update')")
    public Activity updateActivity(@RequestBody Activity activity) {
        return activityService.updateActivity(activity);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('activities:delete')")
    public ResponseEntity<?> deleteActivity(@PathVariable UUID id) {
        try {
            activityService.deleteActivity(id);
        } catch (RuntimeException exception) {
            log.error(exception.getMessage());
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(true);
    }
}
