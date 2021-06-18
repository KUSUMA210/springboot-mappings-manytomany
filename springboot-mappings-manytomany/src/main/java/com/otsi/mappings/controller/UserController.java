package com.otsi.mappings.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.otsi.mappings.dto.UserDto;
import com.otsi.mappings.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/user")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
		UserDto user = userService.addUser(userDto);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	@GetMapping("/Users")
	public ResponseEntity<List<UserDto>> getAllUsers() {
		List<UserDto> users = userService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	@PutMapping("/user/{id}")
	public ResponseEntity<UserDto> updateStudent(@PathVariable(name = "id") Long id,@RequestBody UserDto userDto) {
		UserDto usr = userService.updateUser(id, userDto);
		return new ResponseEntity<>(usr, HttpStatus.CREATED);
	}
	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable(name = "id") Long id) {
		String message = userService.deleteUser(id);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

}
