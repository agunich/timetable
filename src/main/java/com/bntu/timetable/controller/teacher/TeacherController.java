package com.bntu.timetable.controller.teacher;

import com.bntu.timetable.dto.teacher.InfoForTeacherCreation;
import com.bntu.timetable.entity.teacher.Teacher;
import com.bntu.timetable.service.api.teacher.TeacherService;
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
@RequestMapping("api/v1/teachers")
@Slf4j
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('teacher:read')")
    public ResponseEntity<?> getTeacher(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(teacherService.getTeacher(id));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/loadDataForCreation")
    @PreAuthorize("hasAuthority('teacher:read')")
    public ResponseEntity<InfoForTeacherCreation> loadDataForTeacherCreation() {
            return ResponseEntity.ok(teacherService.loadDataForTeacherCreation());
    }


    @GetMapping
    @PreAuthorize("hasAuthority('teacher:read')")
    public List<Teacher> getTeachers() {
        return teacherService.getTeachers();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('teacher:create')")
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return teacherService.createTeacher(teacher);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('teacher:update')")
    public Teacher updateTeacher(@RequestBody Teacher teacher) {
        return teacherService.updateTeacher(teacher);
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('teacher:delete')")
    public ResponseEntity<?> deleteTeacher(@PathVariable UUID id) {
        try {
            teacherService.deleteTeacher(id);
        } catch (RuntimeException exception) {
            log.error(exception.getMessage());
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(true);
    }
}
