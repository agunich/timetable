package com.bntu.timetable.converters;


import com.bntu.timetable.dto.user.DeaneryShortDto;
import com.bntu.timetable.dto.user.DepartmentShortDto;
import com.bntu.timetable.dto.user.RoleShortDto;
import com.bntu.timetable.dto.user.UserDto;
import com.bntu.timetable.entity.*;
import com.bntu.timetable.entity.user.Permission;
import com.bntu.timetable.entity.user.Role;
import com.bntu.timetable.entity.user.User;

import java.util.List;
import java.util.stream.Collectors;


public class UserConverter {

    public static UserDto convertUserToDto(User user) {
        UserDto userDto = new UserDto();

        if (user.getDeanery() != null) {
            userDto.setDeanery(convertDeaneryToDto(user.getDeanery()));
        }

        if (user.getDepartment() != null) {
            userDto.setDepartment(convertDepartmentToDto(user.getDepartment()));
        }

        userDto.setRole(convertRoleToDto(user.getRole()));

        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setPatronymic(user.getPatronymic());
        userDto.setStatus(user.getStatus());

        return userDto;
    }


    private static DepartmentShortDto convertDepartmentToDto(Department department) {
        DepartmentShortDto departmentShortDto = new DepartmentShortDto();
        departmentShortDto.setId(department.getId());
        departmentShortDto.setFullName(department.getFullName());
        departmentShortDto.setShortname(department.getShortName());
        return departmentShortDto;
    }

    private static DeaneryShortDto convertDeaneryToDto(Deanery deanery) {
        DeaneryShortDto deaneryShortDto = new DeaneryShortDto();
        deaneryShortDto.setId(deanery.getId());
        deaneryShortDto.setFullName(deanery.getFullName());
        deaneryShortDto.setShortname(deanery.getShortName());
        return deaneryShortDto;
    }

    private static RoleShortDto convertRoleToDto(Role role) {
        RoleShortDto roleShortDto = new RoleShortDto();
        roleShortDto.setId(role.getId());
        roleShortDto.setName(role.getName());
        roleShortDto.setRoleCategory(role.getRoleCategory());
        roleShortDto.setPermissions(role.getPermissions().stream().map(Permission::getName).collect(Collectors.toList()));
        return roleShortDto;
    }

    public static List<UserDto> convertUsersToDto(List<User> users) {
        return users.stream().map(UserConverter::convertUserToDto).collect(Collectors.toList());
    }
}
