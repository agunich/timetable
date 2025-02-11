package com.bntu.timetable.controller.teacher;

import com.bntu.timetable.entity.teacher.AcademicTitle;
import com.bntu.timetable.service.api.teacher.AcademicTitleService;
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
@RequestMapping("api/v1/academic_titles")
@Slf4j
public class AcademicTitleController {

    @Autowired
    private AcademicTitleService academicTitleService;

    @GetMapping
    @PreAuthorize("hasAuthority('titles:read')")
    public List<AcademicTitle> getAcademicTitles() {
        return academicTitleService.getAcademicTitles();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('titles:create')")
    public AcademicTitle createAcademicTitle(@RequestBody AcademicTitle academicTitle) {
        return academicTitleService.createAcademicTitle(academicTitle);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('titles:update')")
    public AcademicTitle updateAcademicTitle(@RequestBody AcademicTitle academicTitle) {
        return academicTitleService.updateAcademicTitle(academicTitle);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('titles:delete')")
    public ResponseEntity<?> deleteAcademicTitle(@PathVariable UUID id) {
        try {
            academicTitleService.deleteAcademicTitle(id);
        } catch (RuntimeException exception) {
            log.error(exception.getMessage());
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(true);
    }
}
