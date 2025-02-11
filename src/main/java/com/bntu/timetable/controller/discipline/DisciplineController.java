package com.bntu.timetable.controller.discipline;

import com.bntu.timetable.entity.studyplan.structure.Discipline;
import com.bntu.timetable.service.api.discipline.DisciplineService;
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
@RequestMapping("api/v1/disciplines")
@Slf4j
public class DisciplineController {
    @Autowired
    private DisciplineService disciplineService;

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('discipline:read')")
    public ResponseEntity<?> getDiscipline(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(disciplineService.getDiscipline(id));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @PreAuthorize("hasAuthority('discipline:read')")
    public List<Discipline> getDisciplines() {
        return disciplineService.getDisciplineTemplates();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('discipline:create')")
    public Discipline createDiscipline(@RequestBody Discipline discipline) {
        return disciplineService.createDiscipline(discipline);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('discipline:update')")
    public Discipline updateDiscipline(@RequestBody Discipline discipline) {
        return disciplineService.updateDiscipline(discipline);
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('discipline:delete')")
    public ResponseEntity<?> deleteDiscipline(@PathVariable UUID id) {
        try {
            disciplineService.deleteDiscipline(id);
        } catch (RuntimeException exception) {
            log.error(exception.getMessage());
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(true);
    }
}
