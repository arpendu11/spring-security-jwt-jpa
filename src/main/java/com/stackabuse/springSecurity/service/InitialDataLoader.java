package com.stackabuse.springSecurity.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.stackabuse.springSecurity.model.Role;
import com.stackabuse.springSecurity.model.RoleName;
import com.stackabuse.springSecurity.repository.RoleRepository;

@Component
public class InitialDataLoader {
	
	@Autowired
	private RoleRepository roleRepository;

	@Bean
	public ApplicationRunner initializer() {
		List<RoleName> roles = Arrays.asList(RoleName.ROLE_ADMIN, RoleName.ROLE_THERAPIST, RoleName.ROLE_USER);
	    return args -> roles.forEach(i -> createRoleIfNotFound(i));
	}
	
	private Optional<Role> createRoleIfNotFound(RoleName roleName) {
        Optional<Role> role = roleRepository.findByName(roleName);
        if (!role.isPresent()) {
        	Role newRole = new Role();
        	newRole.setName(roleName);
        	newRole = roleRepository.save(newRole);
        }
        return role;
    }
}
