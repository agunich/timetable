package com.bntu.timetable.controller;

import com.bntu.timetable.entity.University;
import com.bntu.timetable.service.api.UniversityService;
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
@RequestMapping("api/v1/universities")
@Slf4j
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    @GetMapping
    @PreAuthorize("hasAuthority('universities:read')")
    public List<University> getUniversities() {
        return universityService.getUniversities();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('universities:create')")
    public University createUniversity(@RequestBody University university) {
        return universityService.createUniversity(university);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('universities:update')")
    public University updateUniversity(@RequestBody University university) {
        return universityService.updateUniversity(university);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('universities:delete')")
    public ResponseEntity<?> deleteUniversity(@PathVariable UUID id) {
        try {
            universityService.deleteUniversity(id);
        } catch (RuntimeException exception) {
            log.error(exception.getMessage());
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(true);
    }
}
