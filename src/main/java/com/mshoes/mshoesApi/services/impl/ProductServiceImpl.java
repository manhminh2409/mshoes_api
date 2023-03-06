package com.mshoes.mshoesApi.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mshoes.mshoesApi.exception.ResourceNotFoundException;
import com.mshoes.mshoesApi.libraries.Utilities;
import com.mshoes.mshoesApi.mapper.ProductMapper;
import com.mshoes.mshoesApi.models.Product;
import com.mshoes.mshoesApi.models.DTO.ProductDTO;
import com.mshoes.mshoesApi.repositories.ProductRepository;
import com.mshoes.mshoesApi.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private final ProductRepository productRepository;

	@Autowired
	private final ProductMapper productMapper;

	@Autowired
	private final Utilities utilities;

	public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper, Utilities utilities) {
		this.productRepository = productRepository;
		this.productMapper = productMapper;
		this.utilities = utilities;
	}

	@Override
	public ProductDTO createProduct(ProductDTO productDTO) {

		// set currentdate
		productDTO.setProductCreatedDate(utilities.getCurrentDate());
		productDTO.setProductLastModified(utilities.getCurrentDate());

		// Convert DTO to entity
		Product product = productMapper.toEntity(productDTO);

		Product newProduct = productRepository.save(product);

		// Convert entity to DTO
		ProductDTO productResponse = productMapper.toDTO(newProduct);

		return productResponse;
	}

	@Override
	public List<ProductDTO> getAllProducts() {
		List<Product> products = productRepository.findAll();
		return products.stream().map(product -> productMapper.toDTO(product)).collect(Collectors.toList());
	}

	@Override
	public ProductDTO getProductById(Long productId) {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
		return productMapper.toDTO(product);
	}

	@Override
	public List<ProductDTO> getProductsByCategoryId(Long categoryId) {
		// TODO Auto-generated method stub
		List<Product> products = productRepository.findByCategoryId(categoryId);

		return products.stream().map(product -> productMapper.toDTO(product)).collect(Collectors.toList());
	}

	@Override
	public ProductDTO updateProduct(ProductDTO productDTO, long productId) {
		// get product by id from the database
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));

		productDTO.setId(productId);
		productDTO.setProductLastModified(utilities.getCurrentDate());
		// Set new information
		product = productMapper.toEntity(productDTO);

		Product responseProduct = productRepository.save(product);

		return productMapper.toDTO(responseProduct);
	}

	@Override
	public void deleteProductById(long productId) {
		// get product by id from the database
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));

		try {
			productRepository.delete(product);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("Ex: " + e);
		}

	}

}
