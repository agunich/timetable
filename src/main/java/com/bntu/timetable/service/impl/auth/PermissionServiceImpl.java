package com.bntu.timetable.service.impl.auth;

import com.bntu.timetable.entity.user.Permission;
import com.bntu.timetable.repository.auth.PermissionRepository;
import com.bntu.timetable.service.api.auth.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public List<Permission> getPermissions() {
        return permissionRepository.findAll();
    }

}
