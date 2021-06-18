package com.otsi.mappings.serviceimp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.otsi.mappings.dto.UserDto;
import com.otsi.mappings.mapper.UserMapper;
import com.otsi.mappings.model.UserModel;
import org.springframework.transaction.annotation.Transactional;
import com.otsi.mappings.repository.UserRepository;
import com.otsi.mappings.service.UserService;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<UserDto> getAllUsers() {
		List<UserDto> userDtos = new ArrayList<>();
		List<UserModel> users = userRepository.findAll();
		users.stream().forEach(user -> {
			UserDto userDto = userMapper.mapEntityToDto(user);
			userDtos.add(userDto);
		});
		return userDtos;
	}

	@Transactional
	@Override
	public UserDto addUser(UserDto userDto) {
		UserModel user = new UserModel();
		userMapper.mapDtoToEntity(userDto, user);
		UserModel savedUser = userRepository.save(user);
		return userMapper.mapEntityToDto(savedUser);
	}

	@Transactional
	@Override
	public UserDto updateUser(Long id, UserDto userDto) {
		UserModel usr = userRepository.getOne(id);
		usr.getRoles().clear();
		userMapper.mapDtoToEntity(userDto, usr);
		UserModel user = userRepository.save(usr);
		return userMapper.mapEntityToDto(user);
	}

	@Override
	public String deleteUser(Long id) {
	Optional<UserModel> user = userRepository.findById(id);
		// Remove the related roles from user entity.
		if (user.isPresent()) {
			user.get().removeRoles();
			userRepository.deleteById(user.get().getId());
			return "Student with id: " + id + " deleted successfully!";
		}
		return null;
	}
}
