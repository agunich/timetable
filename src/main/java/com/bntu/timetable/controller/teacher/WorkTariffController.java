package com.bntu.timetable.controller.teacher;

import com.bntu.timetable.entity.teacher.WorkTariff;
import com.bntu.timetable.service.api.teacher.WorkTariffService;
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
@RequestMapping("api/v1/work_tariffs")
@Slf4j
public class WorkTariffController {

    @Autowired
    private WorkTariffService workTariffService;

    @GetMapping
    @PreAuthorize("hasAuthority('worktariffs:read')")
    public List<WorkTariff> getWorkTariffs() {
        return workTariffService.getWorkTariffs();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('worktariffs:create')")
    public WorkTariff createWorkTariff(@RequestBody WorkTariff workTariff) {
        return workTariffService.createWorkTariff(workTariff);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('worktariffs:update')")
    public WorkTariff updateWorkTariff(@RequestBody WorkTariff workTariff) {
        return workTariffService.updateWorkTariff(workTariff);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('worktariffs:delete')")
    public ResponseEntity<?> deleteWorkTariff(@PathVariable UUID id) {
        try {
            workTariffService.deleteWorkTariff(id);
        } catch (RuntimeException exception) {
            log.error(exception.getMessage());
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(true);
    }
}
