package com.bntu.timetable.controller.studyplan;

import com.bntu.timetable.entity.studyplan.structure.SemesterLoad;
import com.bntu.timetable.service.api.studyplan.SemesterLoadService;
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
@RequestMapping("api/v1/semester_loads")
@Slf4j
public class SemesterLoadController {

    @Autowired
    private SemesterLoadService semesterLoadService;

    @GetMapping
    @PreAuthorize("hasAuthority('semester_loads:read')")
    public List<SemesterLoad> getSemesterLoads() {
        return semesterLoadService.getSemesterLoads();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('semester_loads:create')")
    public SemesterLoad createSemesterLoad(@RequestBody SemesterLoad semesterLoad) {
        return semesterLoadService.createSemesterLoad(semesterLoad);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('semester_loads:update')")
    public SemesterLoad updateSemesterLoad(@RequestBody SemesterLoad semesterLoad) {
        return semesterLoadService.updateSemesterLoad(semesterLoad);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('semester_loads:delete')")
    public ResponseEntity<?> deleteSemesterLoad(@PathVariable UUID id) {
        try {
            semesterLoadService.deleteSemesterLoad(id);
        } catch (RuntimeException exception) {
            log.error(exception.getMessage());
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(true);
    }
}
