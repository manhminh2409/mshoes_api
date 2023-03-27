package com.mshoes.mshoesApi.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mshoes.mshoesApi.models.User;
import com.mshoes.mshoesApi.models.DTO.UserDTO;

@Service
public class UserMapper {

	@Autowired
	private ModelMapper modelMapper;

	public ModelMapper getModelMapper() {
		return modelMapper;
	}

	public void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	/**
	 * Method convert User to UserDTO using ModelMapper <br>
	 * <u><i>Update: 26/02/2023</i></u>
	 *
	 * @param user
	 * @return
	 */
	public UserDTO toDTO(User user) {
		return modelMapper.map(user, UserDTO.class);
	}

	/**
	 * Method convert UserDTO to User using ModelMapper <br>
	 * <u><i>Update: 26/02/2023</i></u>
	 *
	 * @param userDTO
	 * @return
	 */
	public User toEntity(UserDTO userDTO) {
		return modelMapper.map(userDTO, User.class);
	}

}
