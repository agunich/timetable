package com.bntu.timetable.controller.department;

import com.bntu.timetable.entity.Speciality;
import com.bntu.timetable.service.api.department.SpecialityService;
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
@RequestMapping("api/v1/specialities")
@Slf4j
public class SpecialityController {

    @Autowired
    private SpecialityService specialityService;

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('speciality:read')")
    public ResponseEntity<?> getSpeciality(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(specialityService.getSpeciality(id));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @PreAuthorize("hasAuthority('speciality:read')")
    public List<Speciality> getSpecialities(@RequestParam(required = false) UUID departmentId,
                                            @RequestParam(required = false) UUID deaneryId) {
        if (departmentId != null) {
            return specialityService.getSpecialitiesByDepartment(departmentId);
        } else if (deaneryId != null) {
            return specialityService.getSpecialitiesByDeanery(deaneryId);
        }
        return specialityService.getSpecialities();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('speciality:create')")
    public Speciality createSpeciality(@RequestBody Speciality speciality) {
        return specialityService.createSpeciality(speciality);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('speciality:update')")
    public Speciality updateSpeciality(@RequestBody Speciality speciality) {
        return specialityService.updateSpeciality(speciality);
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('speciality:delete')")
    public ResponseEntity<?> deleteSpeciality(@PathVariable UUID id) {
        try {
            specialityService.deleteSpeciality(id);
        } catch (RuntimeException exception) {
            log.error(exception.getMessage());
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(true);
    }

}
