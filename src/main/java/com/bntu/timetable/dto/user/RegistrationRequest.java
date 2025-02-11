package com.bntu.timetable.dto.user;

import com.bntu.timetable.entity.user.Role;
import lombok.Data;

import java.util.UUID;

@Data
public class RegistrationRequest {
    private String email;
    private String firstName;
    private String lastName;
    private String patronymic;
    private Role role;
    private UUID departmentId;
    private UUID deaneryId;
}
