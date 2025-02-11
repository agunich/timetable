package com.bntu.timetable.controller.studyplan;

import com.bntu.timetable.entity.studyplan.structure.Load;
import com.bntu.timetable.service.api.studyplan.LoadService;
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
@RequestMapping("api/v1/loads")
@Slf4j
public class LoadController {

    @Autowired
    private LoadService loadService;

    @GetMapping
    @PreAuthorize("hasAuthority('loads:read')")
    public List<Load> getLoads() {
        return loadService.getLoads();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('loads:create')")
    public Load createLoad(@RequestBody Load load) {
        return loadService.createLoad(load);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('loads:update')")
    public Load updateLoad(@RequestBody Load load) {
        return loadService.updateLoad(load);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('loads:delete')")
    public ResponseEntity<?> deleteLoad(@PathVariable UUID id) {
        try {
            loadService.deleteLoad(id);
        } catch (RuntimeException exception) {
            log.error(exception.getMessage());
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(true);
    }
}
