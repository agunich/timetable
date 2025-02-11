package com.bntu.timetable.controller.deanery;

import com.bntu.timetable.entity.Group;
import com.bntu.timetable.service.api.deanery.GroupService;
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
@RequestMapping("api/v1/groups")
@Slf4j
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('group:read')")
    public ResponseEntity<?> getGroup(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(groupService.getGroup(id));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @PreAuthorize("hasAuthority('group:read')")
    public List<Group> getGroups(@RequestParam(required = false) UUID deaneryId,
                                 @RequestParam(required = false) UUID departmentId) {
        if (deaneryId != null) {
            return  groupService.getGroupsByDeaneryId(deaneryId);
        } else if (departmentId != null) {
            return groupService.getGroupsByDepartmentId(departmentId);
        }
        return groupService.getGroups();
    }


    @PostMapping
    @PreAuthorize("hasAuthority('group:create')")
    public Group createGroup(@RequestBody Group group) {
        return groupService.createGroup(group);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('group:update')")
    public Group updateGroup(@RequestBody Group group) {
        return groupService.updateGroup(group);
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('group:delete')")
    public ResponseEntity<?> deleteGroup(@PathVariable UUID id) {
        try {
            groupService.deleteGroup(id);
        } catch (RuntimeException exception) {
            log.error(exception.getMessage());
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(true);
    }
}
