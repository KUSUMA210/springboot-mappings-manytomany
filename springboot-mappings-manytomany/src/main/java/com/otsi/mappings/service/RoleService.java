package com.otsi.mappings.service;

import org.springframework.http.ResponseEntity;

import com.otsi.mappings.model.RoleModel;

public interface RoleService {

	RoleModel addRole(RoleModel role);

	RoleModel findByName(String name);

	ResponseEntity<Object> deleteRole(Long id);


}
