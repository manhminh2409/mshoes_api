package com.mshoes.mshoesApi.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mshoes.mshoesApi.exception.ResourceNotFoundException;
import com.mshoes.mshoesApi.libraries.Utilities;
import com.mshoes.mshoesApi.mapper.ImageMapper;
import com.mshoes.mshoesApi.mapper.ProductMapper;
import com.mshoes.mshoesApi.models.Image;
import com.mshoes.mshoesApi.models.Product;
import com.mshoes.mshoesApi.models.DTO.ProductDTO;
import com.mshoes.mshoesApi.models.DTO.RequestedImage;
import com.mshoes.mshoesApi.models.DTO.RequestedProduct;
import com.mshoes.mshoesApi.repositories.ImageRepository;
import com.mshoes.mshoesApi.repositories.ProductRepository;
import com.mshoes.mshoesApi.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private final ProductRepository productRepository;

	@Autowired
	private final ImageRepository imageRepository;

	@Autowired
	private final ProductMapper productMapper;

	@Autowired
	private final ImageMapper imageMapper;

	@Autowired
	private final Utilities utilities;

	public ProductServiceImpl(ProductRepository productRepository, ImageRepository imageRepository,
			ProductMapper productMapper, ImageMapper imageMapper, Utilities utilities) {
		this.productRepository = productRepository;
		this.imageRepository = imageRepository;
		this.productMapper = productMapper;
		this.imageMapper = imageMapper;
		this.utilities = utilities;
	}

	@Override
	public ProductDTO createProduct(RequestedProduct requestedProduct) {
		Product product = productMapper.mapRequestedToModel(requestedProduct);

		// set current date
		product.setProductCreatedDate(utilities.getCurrentDate());
		product.setProductLastModified(utilities.getCurrentDate());

		// Save new product to database
		Product newProduct = productRepository.save(product);

		// Get id of product create recently
		long productId = newProduct.getId();

		// Save image into table image
		List<String> imageUrls = requestedProduct.getImageUrls();
		saveImages(imageUrls, productId);

		// Convert entity to DTO
		ProductDTO productResponse = productMapper.mapModelToDTO(newProduct);

		return productResponse;
	}

	private void saveImages(List<String> imageUrls, long productId) {
		if (imageUrls != null) {
			for (String imageUrl : imageUrls) {
				RequestedImage requestedImage = new RequestedImage();
				requestedImage.setImageUrl(imageUrl);
				requestedImage.setProductId(productId);

				Image image = imageMapper.mapRequestedToModel(requestedImage);

				imageRepository.save(image);
			}
		}
	}

	@Override
	public List<ProductDTO> getAllProducts() {
		List<Product> products = productRepository.findAll();
		return productMapper.mapModelToDTOs(products);
	}

	@Override
	public ProductDTO getProductById(Long productId) {
		productRepository.incrementVisitedById(productId);
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));

		return productMapper.mapModelToDTO(product);
	}

	@Override
	public List<ProductDTO> getProductsByCategoryId(Long categoryId) {
		// TODO Auto-generated method stub
		List<Product> products = productRepository.findByCategoryId(categoryId);

		return productMapper.mapModelToDTOs(products);
	}

	@Override
	public ProductDTO updateProduct(RequestedProduct requestedProduct, long productId) {
		// get product by id from the database
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));

		productMapper.updateModel(product, requestedProduct);
		product.setProductLastModified(utilities.getCurrentDate());

		Product responseProduct = productRepository.save(product);

		return productMapper.mapModelToDTO(responseProduct);
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
