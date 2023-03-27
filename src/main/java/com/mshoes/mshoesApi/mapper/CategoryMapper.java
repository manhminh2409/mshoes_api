package com.mshoes.mshoesApi.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mshoes.mshoesApi.models.Category;
import com.mshoes.mshoesApi.models.DTO.CategoryDTO;

@Service
public class CategoryMapper {

	@Autowired
	private ModelMapper modelMapper;

	public ModelMapper getModelMapper() {
		return modelMapper;
	}

	public void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	/**
	 * Method convert Category to CategoryDTO using ModelMapper <br>
	 * <u><i>Update: 06/03/2023</i></u>
	 *
	 * @param Category
	 * @return
	 */
	public CategoryDTO toDTO(Category category) {
		return modelMapper.map(category, CategoryDTO.class);
	}

	/**
	 * Method convert CategoryDTO to Category using ModelMapper <br>
	 * <u><i>Update: 06/03/2023</i></u>
	 *
	 * @param CategoryDTO
	 * @return
	 */
	public Category toEntity(CategoryDTO categoryDTO) {
		return modelMapper.map(categoryDTO, Category.class);
	}

}
