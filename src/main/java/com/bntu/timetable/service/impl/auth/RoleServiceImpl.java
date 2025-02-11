package com.bntu.timetable.service.impl.auth;

import com.bntu.timetable.entity.user.Role;
import com.bntu.timetable.errorhandling.ErrorMessage;
import com.bntu.timetable.repository.auth.RoleRepository;
import com.bntu.timetable.service.api.auth.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role getRole(UUID id) {
        return getRoleById(id);
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(Role roleUpdateInfo) {
        Role role = getRoleById(roleUpdateInfo.getId());
        role.setName(roleUpdateInfo.getName());
        role.setPermissions(roleUpdateInfo.getPermissions());
        role.setRoleCategory(roleUpdateInfo.getRoleCategory());
        return roleRepository.save(role);
    }

    private Role getRoleById(UUID roleId) {
        Role role = roleRepository.findById(roleId).orElse(null);
        if (role == null) {
            throw new RuntimeException(ErrorMessage.ROLE_NOT_FOUND);
        }
        return role;
    }

    @Override
    public void deleteRole(UUID id) {
        roleRepository.deleteById(id);
    }
}
