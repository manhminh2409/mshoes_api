package com.mshoes.mshoesApi.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mshoes.mshoesApi.exception.ResourceNotFoundException;
import com.mshoes.mshoesApi.libraries.Utilities;
import com.mshoes.mshoesApi.mapper.CategoryMapper;
import com.mshoes.mshoesApi.models.Category;
import com.mshoes.mshoesApi.models.DTO.CategoryDTO;
import com.mshoes.mshoesApi.repositories.CategoryRepository;
import com.mshoes.mshoesApi.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private final CategoryRepository categoryRepository;

	@Autowired
	private final CategoryMapper categoryMapper;

	@Autowired
	private final Utilities utilities;

	public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper,
			Utilities utilities) {
		super();
		this.categoryRepository = categoryRepository;
		this.categoryMapper = categoryMapper;
		this.utilities = utilities;
	}

	@Override
	public List<CategoryDTO> getAllcategorys() {
		// TODO Auto-generated method stub
		List<Category> categories = categoryRepository.findAll();
		return categoryMapper.mapModelToDTOs(categories);
	}

	@Override
	public CategoryDTO getCategoryById(long categoryId) {
		// TODO Auto-generated method stub
		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Id", categoryId));

		return categoryMapper.mapModelToDTO(category);
	}

	@Override
	public CategoryDTO createCategory(CategoryDTO categoryDTO) {
		// TODO Auto-generated method stub

		// Get current date and set categoryCreatedDate, categoryLastModified
		categoryDTO.setCategoryCreatedDate(utilities.getCurrentDate());
		categoryDTO.setCategoryLastModified(utilities.getCurrentDate());

		// Set default status
		categoryDTO.setCategoryStatus(1);

		// Convert and save
		Category category = categoryRepository.save(categoryMapper.mapDTOToModel(categoryDTO));

		return categoryMapper.mapModelToDTO(category);
	}

	@Override
	public CategoryDTO updateCategory(CategoryDTO categoryDTO, long categoryId) {
		// TODO Auto-generated method stub
		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Id", categoryId));

		categoryDTO.setId(categoryId);
		categoryDTO.setCategoryLastModified(utilities.getCurrentDate());

		category = categoryMapper.mapDTOToModel(categoryDTO);

		// Save
		Category responseCategory = categoryRepository.save(category);

		return categoryMapper.mapModelToDTO(responseCategory);
	}

	@Override
	public void deleteCategory(long categoryId) {
		// TODO Auto-generated method stub
		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Id", categoryId));
		try {
			categoryRepository.delete(category);
		} catch (Exception ex) {
			System.out.print("Ex: " + ex);
		}
	}

}
