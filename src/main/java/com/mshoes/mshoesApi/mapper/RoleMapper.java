package com.mshoes.mshoesApi.mapper;

import com.mshoes.mshoesApi.models.DTO.RoleDTO;
import com.mshoes.mshoesApi.models.Role;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleMapper {
	@Autowired
	private ModelMapper modelMapper;

	public ModelMapper getModelMapper() {
		return modelMapper;
	}

	public void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	/**
	 * Method convert Role to RoleDTO using ModelMapper <br>
	 * <u><i>Update: 09/03/2023</i></u>
	 *
	 * @param role
	 * @return
	 */
	public RoleDTO toDTO(Role role) {
		return modelMapper.map(role, RoleDTO.class);
	}

	/**
	 * Method convert roleDTO to role using ModelMapper <br>
	 * <u><i>Update: 09/03/2023</i></u>
	 *
	 * @param roleDTO
	 * @return
	 */
	public Role toEntity(RoleDTO roleDTO) {
		return modelMapper.map(roleDTO, Role.class);
	}

}
