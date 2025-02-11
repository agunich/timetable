package com.bntu.timetable.controller.auth;


import com.bntu.timetable.converters.UserConverter;
import com.bntu.timetable.entity.user.User;
import com.bntu.timetable.service.api.auth.UserService;
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
@RequestMapping("api/v1/users")
@Slf4j
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('users:read')")
    public ResponseEntity<?> getUser(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(userService.findById(id));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @PreAuthorize("hasAuthority('users:read')")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('users:delete')")
    public ResponseEntity<?> deleteUser(@PathVariable UUID id) {
        try {
            log.debug("Delete user with Id: {}", id);
            userService.delete(id);
            log.debug("User was deleted");
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    @PreAuthorize("hasAuthority('users:update')")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        try {
            return ResponseEntity.ok(userService.updateUser(UserConverter.convertUserToDto(user)));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/verifyUser")
    public ResponseEntity<?> verifyUser(@RequestParam("id") UUID id) {
        try {
            log.debug("Verify user with Id: {}", id);
            userService.verifyUser(id);
            log.debug("User activation was completed");
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/block/{id}")
    @PreAuthorize("hasAuthority('users:block')")
    public ResponseEntity<?> blockUser(@PathVariable("id") UUID id, @RequestBody Boolean isNeedToBlock) {
        try {
            userService.changeStatus(id, isNeedToBlock);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


}
