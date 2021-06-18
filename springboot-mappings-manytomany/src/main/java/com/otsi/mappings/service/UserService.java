package com.otsi.mappings.service;

import java.util.List;
import com.otsi.mappings.dto.UserDto;

public interface UserService {

	List<UserDto> getAllUsers();

	UserDto addUser(UserDto userDto);

	UserDto updateUser(Long id, UserDto userDto);

	String deleteUser(Long id);

}
