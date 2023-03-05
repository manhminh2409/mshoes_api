package com.mshoes.mshoesApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mshoes.mshoesApi.models.DTO.CategoryDTO;
import com.mshoes.mshoesApi.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}

	@GetMapping
	public List<CategoryDTO> getAllCategory() {
		return categoryService.getAllcategorys();
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable(name = "id") Long categoryId) {
		return ResponseEntity.ok(categoryService.getCategoryById(categoryId));
	}

	@PostMapping("/create")
	public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
		return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<CategoryDTO> updateCategory(@PathVariable(name = "id") long categoryId,
			@RequestBody CategoryDTO categoryDTO) {
		CategoryDTO responseUser = categoryService.updateCategory(categoryDTO, categoryId);

		return new ResponseEntity<>(responseUser, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable(name = "id") long categoryId) {

		try {
			categoryService.deleteCategory(categoryId);

			return new ResponseEntity<>("Product deleted successfully.", HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("Delete fail!!", HttpStatus.OK);
		}
	}
}
