package com.bntu.timetable.dto.user;

import com.bntu.timetable.entity.user.RoleCategory;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class RoleShortDto {

    private UUID id;

    private String name;

    private RoleCategory roleCategory;

    private List<String> permissions;

}
