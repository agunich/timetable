package com.bntu.timetable.controller.timetable;

import com.bntu.timetable.entity.timetable.Timetable;
import com.bntu.timetable.entity.timetable.TimetableStatus;
import com.bntu.timetable.service.api.timetable.TimetableService;
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
@RequestMapping("api/v1/timetables")
@Slf4j
public class TimetableController {

    @Autowired
    private TimetableService timetableService;

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('timetable:read')")
    public ResponseEntity<?> getTimetable(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(timetableService.getTimetable(id));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("deanery/{deaneryId}/dialog-common-info")
    @PreAuthorize("hasAuthority('timetable:read')")
    public ResponseEntity<?> getTimetableDialogCreationCommonInfo(@PathVariable UUID deaneryId) {
        try {
            return ResponseEntity.ok(timetableService.loadDialogCreateCommonInfo(deaneryId));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/create-common-info")
    @PreAuthorize("hasAuthority('timetable:read')")
    public ResponseEntity<?> getTimetableStudyPlanToGroupsInfo() {
        try {
            return ResponseEntity.ok(timetableService.loadCreateCommonInfo());
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @PreAuthorize("hasAuthority('timetable:read')")
    public List<Timetable> getTimetables(@RequestParam(required = false) UUID deaneryId) {
        if (deaneryId != null) {
            return timetableService.getTimetables(deaneryId);
        }
        return timetableService.getTimetables();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('timetable:create')")
    public Timetable createTimetable(@RequestBody Timetable timetable) {
        return timetableService.createTimetable(timetable);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('timetable:update')")
    public Timetable updateTimetable(@RequestBody Timetable timetable) {
        return timetableService.updateTimetable(timetable);
    }

    @PutMapping("/submit")
    @PreAuthorize("hasAuthority('timetable:submit')")
    public Timetable submitTimetable(@RequestBody Timetable timetable) {
        return timetableService.changeTimetableStatus(timetable.getId(), TimetableStatus.SUBMITTED);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('timetable:delete')")
    public ResponseEntity<?> deleteTimetable(@PathVariable UUID id) {
        try {
            timetableService.deleteTimetable(id);
        } catch (RuntimeException exception) {
            log.error(exception.getMessage());
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(true);
    }
}
