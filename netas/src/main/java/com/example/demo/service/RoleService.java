package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	RoleRepository roleRepository;

	public Role createRole(Role role) {
		roleRepository.save(role);
		return role;
	}
	
	public List<Role> viewRole(Role role) {
		return roleRepository.findAll();
	}

	public Role updateRole(Role role) {
		roleRepository.save(role);
		return role;
	}
	
	public Role deleteRole(Role role) {
		roleRepository.delete(role);
		return role;
	}
}
