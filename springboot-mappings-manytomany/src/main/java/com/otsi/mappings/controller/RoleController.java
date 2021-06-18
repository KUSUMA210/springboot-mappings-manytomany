package com.otsi.mappings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.otsi.mappings.model.RoleModel;
import com.otsi.mappings.service.RoleService;

@RestController
public class RoleController {
	@Autowired
	private RoleService roleService;

	@PostMapping("/role/create")
	public RoleModel createRole(@RequestBody RoleModel role) {
		return roleService.addRole(role);

	}

	@GetMapping("/role/rolename")
	public RoleModel getRoleByName(@RequestParam String name) {
		return roleService.findByName(name);
	}

	@DeleteMapping("/role/delete/{id}")
	public ResponseEntity<Object> deleteRole(@PathVariable Long id) {
		return roleService.deleteRole(id);

	}

}
