package com.bntu.timetable.controller.department;

import com.bntu.timetable.entity.Department;
import com.bntu.timetable.service.api.department.DepartmentService;
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
@RequestMapping("api/v1/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('department:read')")
    public ResponseEntity<?> getDepartment(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(departmentService.getDepartment(id));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @PreAuthorize("hasAuthority('department:read')")
    public List<Department> getDepartments(@RequestParam(name = "deaneryId", required = false) UUID deaneryId) {
        if (deaneryId != null) {
            return departmentService.getDepartments(deaneryId);
        }
        return departmentService.getDepartments();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('department:create')")
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('department:update')")
    public Department updateDepartment(@RequestBody Department department) {
        return departmentService.updateDepartment(department);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('department:delete')")
    public ResponseEntity<?> deleteDepartment(@PathVariable UUID id) {
        try {
            departmentService.deleteDepartment(id);
        } catch (RuntimeException exception) {
            log.error(exception.getMessage());
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(true);
    }

}
