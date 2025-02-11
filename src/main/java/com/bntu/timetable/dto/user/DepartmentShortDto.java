package com.bntu.timetable.dto.user;

import lombok.Data;

import java.util.UUID;

@Data
public class DepartmentShortDto {

    private UUID id;

    private String fullName;

    private String shortname;
}
