package com.mshoes.mshoesApi.mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.mshoes.mshoesApi.models.Category;
import com.mshoes.mshoesApi.models.DTO.CategoryDTO;
import com.mshoes.mshoesApi.models.DTO.RequestedCategory;

@Mapper(uses = ProductMapper.class)
public interface CategoryMapper {

	// mapper one model to dto
	CategoryDTO mapModelToDTO(Category category);

	// mapper list model to dto
	List<CategoryDTO> mapModelToDTOs(List<Category> categories);

	// mapper one dto to model
	Category mapDTOToModel(CategoryDTO categoryDTO);

	// mapper list dto to model
	List<Category> mapDTOToModels(List<CategoryDTO> categoryDTOS);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateModel(@MappingTarget Category category, RequestedCategory requestedCategory);
}
