package com.otsi.mappings.mapper;

import java.util.ArrayList;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.otsi.mappings.dto.UserDto;
import com.otsi.mappings.model.RoleModel;
import com.otsi.mappings.model.UserModel;
import com.otsi.mappings.repository.RoleRepository;

@Component
public class UserMapper {

	@Autowired
	private RoleRepository roleRepository;

	public UserDto mapEntityToDto(UserModel user) {
		UserDto responseDto = new UserDto();
		responseDto.setId(user.getId());
		responseDto.setFirstName(user.getFirstName());
		responseDto.setLastName(user.getLastName());
		responseDto.setMobile(user.getMobile());
		responseDto.setEmail(user.getEmail());
		responseDto.setRoles(user.getRoles().stream().collect(Collectors.toList()));
		return responseDto;
	}

	public void mapDtoToEntity(UserDto userDto, UserModel user) {
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setMobile(userDto.getMobile());
		user.setEmail(userDto.getEmail());
		if (null == user.getRoles()) {
			user.setRoles(new ArrayList<>());
		}
		RoleModel role = roleRepository.findByName(userDto.getRoles().get(0).getName());
		if (null == role) {
			role = new RoleModel();
			role.setUsers(new ArrayList<>());
		}
		role.setName(userDto.getRoles().get(0).getName());
		role.setDescription(userDto.getRoles().get(0).getDescription());
		user.addRole(role);

	}
}