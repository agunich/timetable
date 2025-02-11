package com.bntu.timetable.controller.classroom;

import java.util.List;
import java.util.UUID;

import com.bntu.timetable.dto.classroomfund.BuildingCreateRequest;
import com.bntu.timetable.service.api.classroom.BuildingService;
import com.bntu.timetable.entity.classroom.Building;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/buildings")
@Slf4j
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('buildings:read')")
    public ResponseEntity<?> getBuilding(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(buildingService.getBuilding(id));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @PreAuthorize("hasAuthority('buildings:read')")
    public List<Building> getBuildings() {
        return buildingService.getBuildings();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('buildings:create')")
    public Building createBuilding(@RequestBody BuildingCreateRequest buildingCR) {
        return buildingService.createBuilding(buildingCR);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('buildings:update')")
    public Building updateBuilding(@RequestBody Building building) {
        return buildingService.updateBuilding(building);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('buildings:delete')")
    public ResponseEntity<?> deleteBuilding(@PathVariable UUID id) {
        try {
            buildingService.deleteBuilding(id);
        } catch (RuntimeException exception) {
            log.error(exception.getMessage());
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(true);
    }

}
