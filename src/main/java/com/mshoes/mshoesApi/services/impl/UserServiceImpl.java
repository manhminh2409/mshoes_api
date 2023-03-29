package com.mshoes.mshoesApi.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mshoes.mshoesApi.exception.ResourceNotFoundException;
import com.mshoes.mshoesApi.libraries.Utilities;
import com.mshoes.mshoesApi.mapper.UserMapper;
import com.mshoes.mshoesApi.models.User;
import com.mshoes.mshoesApi.models.DTO.UserDTO;
import com.mshoes.mshoesApi.repositories.UserRepository;
import com.mshoes.mshoesApi.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private final UserRepository userRepository;

	@Autowired
	private final UserMapper userMapper;

	@Autowired
	private final Utilities utilities;

	public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, Utilities utilities) {
		// TODO Auto-generated constructor stub
		this.userRepository = userRepository;
		this.userMapper = userMapper;
		this.utilities = utilities;
	}

	@Override
	public List<UserDTO> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = userRepository.findAll();
		return userMapper.mapModelToDTOs(users);
	}

	@Override
	public UserDTO getUserById(long userId) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		return userMapper.mapModelToDTO(user);
	}

	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		// TODO Auto-generated method stub

		// Get current date and set userCreatedDate and userLastModified
		userDTO.setUserCreatedDate(utilities.getCurrentDate());
		userDTO.setUserLastModified(utilities.getCurrentDate());

		// Encode password

		userDTO.setUserPassword(passwordEncoder().encode(userDTO.getUserPassword()));

		// Set default userStatus
		userDTO.setUserStatus(1);

		// Convert userDTO to User
		User user = userMapper.mapDTOToModel(userDTO);

		// Save user into database
		User responseUser = userRepository.save(user);

		return userMapper.mapModelToDTO(responseUser);
	}

	@Override
	public UserDTO updateUser(UserDTO userDTO, long userId) {
		// TODO Auto-generated method stub

		// Get old User with userId from Database
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "ID", userId));

		userDTO.setId(userId);
		userDTO.setUserLastModified(utilities.getCurrentDate());

		// Set old User with new information from input userDTO
		user = userMapper.mapDTOToModel(userDTO);

		// Save data
		User responseUser = userRepository.save(user);

		return userMapper.mapModelToDTO(responseUser);

	}

	@Override
	public void deleteUser(long userId) {
		// TODO Auto-generated method stub

		// Get old User with userId from Database
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "ID", userId));
		try {
			userRepository.delete(user);
		} catch (Exception ex) {
			System.out.print("Ex: " + ex);
		}
	}
}
