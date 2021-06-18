package com.otsi.mappings.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.otsi.mappings.model.RoleModel;
import com.otsi.mappings.repository.RoleRepository;
import com.otsi.mappings.service.RoleService;

@Service
public class RoleServiceImp implements RoleService {
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public RoleModel addRole(RoleModel role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

	@Override
	public RoleModel findByName(String name) {
		return roleRepository.findByName(name);
	}

	public ResponseEntity<Object> deleteRole(Long id) {
		if (roleRepository.findById(id).isPresent()) {
			if (roleRepository.findById(id).get().getUsers().size()==0) {
				roleRepository.deleteById(id);
				if (roleRepository.findById(id).isPresent()) {
					return ResponseEntity.unprocessableEntity().body("Failed to delete the specified record");
				} else
					return ResponseEntity.ok().body("Successfully deleted specified record");
			}else 
					return ResponseEntity.unprocessableEntity().body("Failed to delete,  Please delete the users associated with this role");
			} else
				return ResponseEntity.unprocessableEntity().body("No Records Found");

		}

	}
