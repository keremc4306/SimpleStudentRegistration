package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepository;

@RestController
@RequestMapping("/api/v1")
public class RolesController {

	private RoleRepository roleRepository;

	@Autowired
	public RolesController(RoleRepository roleRepository) {
		super();
		this.roleRepository = roleRepository;
	}

	@GetMapping("/roles")
	public List<Role> getAll() {
		return this.roleRepository.findAll();
	}

	// create student rest api
	@PostMapping("/roles")
	public Role createRole(@RequestBody Role role) {
		return roleRepository.save(role);
	}

	// update student rest api
	@PutMapping("/roles/{id}")
	public ResponseEntity<Role> updateRole(@PathVariable int id, @RequestBody Role roleDetails) {
		Role role = roleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Role not exist with id :" + id));

		role.setUserLogin(roleDetails.getUserLogin());
		role.setRoleName(roleDetails.getRoleName());

		Role updatedRole = roleRepository.save(role);

		return ResponseEntity.ok(updatedRole);
	}

	// delete student rest api
	@DeleteMapping("/roles/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteRole(@PathVariable int id) {
		Role role = roleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Role not exist with id :" + id));

		roleRepository.delete(role);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
