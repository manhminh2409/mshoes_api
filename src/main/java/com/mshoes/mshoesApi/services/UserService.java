package com.mshoes.mshoesApi.services;

import java.util.List;

import com.mshoes.mshoesApi.models.DTO.UserDTO;

public interface UserService {

	/**
	 * Method get all user is active in database <br>
	 * <u><i>Update: 26/02/2023</i></u>
	 *
	 * @return
	 */
	List<UserDTO> getAllUsers();

	/**
	 * Method get user by userId. <br>
	 * <u><i>Update: 26/02/2023</i></u>
	 *
	 * @param userId
	 * @return
	 */
	UserDTO getUserById(long userId);

	/**
	 * Method create new User <br>
	 * <u><i>Update: 26/02/2023</i></u>
	 *
	 * @param userDTO
	 * @return
	 */
	UserDTO createUser(UserDTO userDTO);

	/**
	 * Method update user with new information User and userId. <br>
	 * <u><i>Update: 26/02/2023</i></u>
	 *
	 * @param userDTO
	 * @param userId
	 * @return
	 */
	UserDTO updateUser(UserDTO userDTO, long userId);

	/**
	 * Method delete user with userId. <br>
	 * <u><i>Update: 26/02/2023</i></u>
	 *
	 * @param userId
	 */
	void deleteUser(long userId);
}
