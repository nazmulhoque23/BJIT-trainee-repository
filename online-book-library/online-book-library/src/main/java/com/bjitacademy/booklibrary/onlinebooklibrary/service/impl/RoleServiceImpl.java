package com.bjitacademy.booklibrary.onlinebooklibrary.service.impl;

import com.bjitacademy.booklibrary.onlinebooklibrary.entity.Role;
import com.bjitacademy.booklibrary.onlinebooklibrary.exception.RoleNotFoundException;
import com.bjitacademy.booklibrary.onlinebooklibrary.repository.RoleRepository;
import com.bjitacademy.booklibrary.onlinebooklibrary.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepo;
    @Override
    public Role getRoles(String roleName){
        Optional<Role> role = roleRepo.findByRoleName(roleName);
        if(role.isPresent()){
            Role requiredRole = role.get();
            return requiredRole;
        }
        else{
            throw new RoleNotFoundException("Role Not found ");
        }
    }

    @Override
    public void addRole(String roleName) {

        if(roleRepo.findByRoleName(roleName).isEmpty()){
            Role role = new Role();
            role.setRoleName(roleName);
            roleRepo.save(role);
        }else{
            return;
        }

    }
}
