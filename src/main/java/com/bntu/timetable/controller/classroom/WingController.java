package com.bntu.timetable.controller.classroom;

import com.bntu.timetable.dto.classroomfund.WingDto;
import com.bntu.timetable.entity.classroom.Wing;
import com.bntu.timetable.service.api.classroom.WingService;
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
@RequestMapping("api/v1/wings")
@Slf4j
public class WingController {

    @Autowired
    private WingService wingService;

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('wings:read')")
    public ResponseEntity<?> getWing(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(wingService.getWing(id));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/classroom/{id}")
    @PreAuthorize("hasAuthority('wings:read')")
    public ResponseEntity<?> getWingByClassroomId(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(wingService.getWingByClassroomId(id));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @PreAuthorize("hasAuthority('wings:read')")
    public List<Wing> getWings() {
        return wingService.getWings();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('wings:create')")
    public Wing createWing(@RequestBody WingDto wing) {
        return wingService.createWing(wing);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('wings:update')")
    public Wing updateWing(@RequestBody WingDto wing) {
        return wingService.updateWing(wing);
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('wings:delete')")
    public ResponseEntity<?> deleteWing(@PathVariable UUID id) {
        try {
            wingService.deleteWing(id);
        } catch (RuntimeException exception) {
            log.error(exception.getMessage());
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(true);
    }


}
