package com.example.flinkwebapp.repository;

import com.example.flinkwebapp.Dto.ERole;
import com.example.flinkwebapp.Dto.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);

    boolean existsByName(ERole eRole);
}