package com.bntu.timetable.controller.classroom;

import java.util.List;
import java.util.UUID;

import com.bntu.timetable.entity.classroom.Classroom;
import com.bntu.timetable.entity.classroom.ClassroomType;
import com.bntu.timetable.service.api.classroom.ClassroomService;

import com.bntu.timetable.service.api.classroom.ClassroomSpecializationService;
import com.bntu.timetable.service.api.classroom.ClassroomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/classrooms")
@Slf4j
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @Autowired
    private ClassroomSpecializationService classroomSpecializationService;

    @Autowired
    private ClassroomTypeService classroomTypeService;

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('classroom:read')")
    public ResponseEntity<?> getClassroom(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(classroomService.getClassroom(id));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/types")
    @PreAuthorize("hasAuthority('classroom:read')")
    public ResponseEntity<?> getClassroomTypes() {
        try {
            return ResponseEntity.ok(classroomTypeService.getClassroomTypes());
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/specializations")
    @PreAuthorize("hasAuthority('classroom:read')")
    public ResponseEntity<?> getClassroomSpecializations() {
        try {
            return ResponseEntity.ok(classroomSpecializationService.getClassroomSpecializations());
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @PreAuthorize("hasAuthority('classroom:read')")
    public List<Classroom> getClassrooms(@RequestParam(required = false) UUID deaneryId,
                                         @RequestParam(required = false) UUID departmentId) {
        if (deaneryId != null) {
            return classroomService.getClassroomByDeaneryId(deaneryId);
        } else if (departmentId != null) {
            return classroomService.getClassroomByDepartmentId(departmentId);
        }
        return classroomService.getClassrooms();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('classroom:create')")
    public Classroom createClassroom(@RequestBody Classroom classroom) {
        return classroomService.createClassroom(classroom);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('classroom:update')")
    public Classroom updateClassroom(@RequestBody Classroom classroom) {
        return classroomService.updateClassroom(classroom);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('classroom:delete')")
    public ResponseEntity<?> deleteClassroom(@PathVariable UUID id) {
        try {
            classroomService.deleteClassroom(id);
        } catch (RuntimeException exception) {
            log.error(exception.getMessage());
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(true);
    }

    @PutMapping("/classroom-type")
    @PreAuthorize("hasAuthority('classroom:update')")
    public ClassroomType updateClassroomType(@RequestBody ClassroomType classroomType) {
        return classroomTypeService.updateClassroomType(classroomType);
    }

}
