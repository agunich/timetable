package com.bntu.timetable.controller.discipline;

import com.bntu.timetable.entity.studyplan.structure.DisciplineGroup;
import com.bntu.timetable.service.api.discipline.DisciplineGroupService;
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
@RequestMapping("api/v1/disciplinegroups")
@Slf4j
public class DisciplineGroupController {

    @Autowired
    private DisciplineGroupService disciplineGroupService;

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('discipline:read')")
    public ResponseEntity<?> getDiscipline(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(disciplineGroupService.getDisciplineGroup(id));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @PreAuthorize("hasAuthority('discipline:read')")
    public List<DisciplineGroup> getDisciplines() {
        return disciplineGroupService.getDisciplineGroups();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('discipline:create')")
    public DisciplineGroup createDiscipline(@RequestBody DisciplineGroup disciplineGroup) {
        return disciplineGroupService.createDisciplineGroup(disciplineGroup);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('discipline:update')")
    public DisciplineGroup updateDiscipline(@RequestBody DisciplineGroup disciplineGroup) {
        return disciplineGroupService.updateDisciplineGroup(disciplineGroup);
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('discipline:delete')")
    public ResponseEntity<?> deleteDiscipline(@PathVariable UUID id) {
        try {
            disciplineGroupService.deleteDisciplineGroup(id);
        } catch (RuntimeException exception) {
            log.error(exception.getMessage());
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(true);
    }

}
