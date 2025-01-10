package com.example.flinkwebapp;

import com.example.flinkwebapp.Dto.ERole;
import com.example.flinkwebapp.Dto.Role;
import com.example.flinkwebapp.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleInitializer {

    @Autowired
    private RoleRepository roleRepository;

    @PostConstruct
    public void initRoles() {
        if (!roleRepository.existsByName(ERole.ROLE_USER)) {
            Role roleUser = new Role(ERole.ROLE_USER);
            roleRepository.save(roleUser);
        }

        if (!roleRepository.existsByName(ERole.ROLE_ADMIN)) {
            Role roleAdmin = new Role(ERole.ROLE_ADMIN);
            roleRepository.save(roleAdmin);
        }
    }
}
