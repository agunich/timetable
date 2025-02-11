package com.bntu.timetable.controller.deanery;

import com.bntu.timetable.entity.Deanery;
import com.bntu.timetable.service.api.deanery.DeaneryService;
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
@RequestMapping("api/v1/deaneries")
@Slf4j
public class DeaneryController {


    @Autowired
    private DeaneryService deaneryService;

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('deanery:read')")
    public ResponseEntity<?> getDeanery(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(deaneryService.getDeanery(id));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @PreAuthorize("hasAuthority('deanery:read')")
    public List<Deanery> getDeaneries() {
        return deaneryService.getDeaneries();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('deanery:create')")
    public Deanery createDeanery(@RequestBody Deanery deanery) {
        return deaneryService.createDeanery(deanery);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('deanery:update')")
    public Deanery updateDeanery(@RequestBody Deanery deanery) {
        return deaneryService.updateDeanery(deanery);
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('deanery:delete')")
    public ResponseEntity<?> deleteDeanery(@PathVariable UUID id) {
        try {
            deaneryService.deleteDeanery(id);
        } catch (RuntimeException exception) {
            log.error(exception.getMessage());
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(true);
    }
}
