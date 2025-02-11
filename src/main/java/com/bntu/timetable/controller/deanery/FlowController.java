package com.bntu.timetable.controller.deanery;


import com.bntu.timetable.entity.Flow;
import com.bntu.timetable.service.api.deanery.FlowService;
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
@RequestMapping("api/v1/flows")
@Slf4j
public class FlowController {

    @Autowired
    private FlowService flowService;

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('flow:read')")
    public ResponseEntity<?> getFlow(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(flowService.getFlow(id));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @PreAuthorize("hasAuthority('flow:read')")
    public List<Flow> getFlows(@RequestParam(required = false) UUID deaneryId,
                               @RequestParam(required = false) UUID departmentId) {
        if (deaneryId != null) {
            return flowService.getFlowsByDeaneryId(deaneryId);
        } else if (departmentId != null) {
            return flowService.getFlowsByDepartmentId(departmentId);
        }
        return flowService.getFlows();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('flow:create')")
    public Flow createFlow(@RequestBody Flow flow) {
        return flowService.createFlow(flow);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('flow:update')")
    public Flow updateFlow(@RequestBody Flow flow) {
        return flowService.updateFlow(flow);
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('flow:delete')")
    public ResponseEntity<?> deleteFlow(@PathVariable UUID id) {
        try {
            flowService.deleteFlow(id);
        } catch (RuntimeException exception) {
            log.error(exception.getMessage());
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(true);
    }

}
