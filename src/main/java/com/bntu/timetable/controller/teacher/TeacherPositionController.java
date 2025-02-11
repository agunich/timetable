package com.bntu.timetable.controller.teacher;

import com.bntu.timetable.entity.teacher.TeacherPosition;
import com.bntu.timetable.service.api.teacher.TeacherPositionService;
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
@RequestMapping("api/v1/positions")
@Slf4j
public class TeacherPositionController {

    @Autowired
    private TeacherPositionService teacherPositionService;

    @GetMapping
    @PreAuthorize("hasAuthority('positions:read')")
    public List<TeacherPosition> getTeacherPositions() {
        return teacherPositionService.getTeacherPositions();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('positions:create')")
    public TeacherPosition createTeacherPosition(@RequestBody TeacherPosition teacherPosition) {
        return teacherPositionService.createTeacherPosition(teacherPosition);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('positions:update')")
    public TeacherPosition updateTeacherPosition(@RequestBody TeacherPosition teacherPosition) {
        return teacherPositionService.updateTeacherPosition(teacherPosition);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('positions:delete')")
    public ResponseEntity<?> deleteTeacherPosition(@PathVariable UUID id) {
        try {
            teacherPositionService.deleteTeacherPosition(id);
        } catch (RuntimeException exception) {
            log.error(exception.getMessage());
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(true);
    }
}
