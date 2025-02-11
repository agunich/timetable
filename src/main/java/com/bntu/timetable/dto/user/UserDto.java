package com.bntu.timetable.dto.user;

import com.bntu.timetable.entity.user.Status;
import lombok.Data;

import java.util.UUID;

@Data
public class UserDto {
    private UUID id;

    private String firstName;

    private String lastName;

    private String patronymic;

    private String email;

    private RoleShortDto role;

    private Status status;

    private String password;

    private DeaneryShortDto deanery;

    private DepartmentShortDto department;
}
