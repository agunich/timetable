package com.bntu.timetable.controller.teacher;

import com.bntu.timetable.entity.teacher.AcademicDegree;
import com.bntu.timetable.service.api.teacher.AcademicDegreeService;
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
@RequestMapping("api/v1/degrees")
@Slf4j
public class AcademicDegreeController {

    @Autowired
    private AcademicDegreeService academicDegreeService;

    @GetMapping
    @PreAuthorize("hasAuthority('degrees:read')")
    public List<AcademicDegree> getAcademicDegrees() {
        return academicDegreeService.getAcademicDegrees();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('degrees:create')")
    public AcademicDegree createAcademicDegree(@RequestBody AcademicDegree academicDegree) {
        return academicDegreeService.createAcademicDegree(academicDegree);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('degrees:update')")
    public AcademicDegree updateAcademicDegree(@RequestBody AcademicDegree academicDegree) {
        return academicDegreeService.updateAcademicDegree(academicDegree);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('degrees:delete')")
    public ResponseEntity<?> deleteAcademicDegree(@PathVariable UUID id) {
        try {
            academicDegreeService.deleteAcademicDegree(id);
        } catch (RuntimeException exception) {
            log.error(exception.getMessage());
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(true);
    }
}
