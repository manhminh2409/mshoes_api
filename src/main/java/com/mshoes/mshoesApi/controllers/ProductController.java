package com.mshoes.mshoesApi.controllers;

import java.util.List;

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

import com.mshoes.mshoesApi.models.DTO.ProductDTO;
import com.mshoes.mshoesApi.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	// Create product POST
	@PostMapping("/create")
	public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {

		return new ResponseEntity<>(productService.createProduct(productDTO), HttpStatus.CREATED);
	}

	// get All products
	@GetMapping
	public List<ProductDTO> getAllProducts() {
		return productService.getAllProducts();
	}

	// get All products
	@GetMapping("/categoryid/{id}")
	public List<ProductDTO> getAllProductsById(@PathVariable(name = "id") Long categoryId) {
		return productService.getAllProductsByCategoryId(categoryId);
	}

	// get Product by ID
	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable(name = "id") Long productId) {

		return ResponseEntity.ok(productService.getProductById(productId));
	}

	// Update Product by ID
	@PutMapping("/update/{id}")
	public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO,
			@PathVariable(name = "id") long productId) {
		ProductDTO productResponse = productService.updateProduct(productDTO, productId);

		return new ResponseEntity<>(productResponse, HttpStatus.OK);
	}

	// Delete Product by ID
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable(name = "id") long productId) {

		productService.deleteProductById(productId);

		return new ResponseEntity<>("Product deleted successfully.", HttpStatus.OK);
	}
}
